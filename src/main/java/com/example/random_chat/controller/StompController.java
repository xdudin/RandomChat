package com.example.random_chat.controller;

import com.example.random_chat.model.ChatPool;
import com.example.random_chat.model.InputMessage;
import com.example.random_chat.model.ResponseMessage;
import com.example.random_chat.model.User;
import com.example.random_chat.model.UserPool;
import com.example.random_chat.service.ChatService;
import com.example.random_chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class StompController {

    private final Logger log = LoggerFactory.getLogger(StompController.class);

    private final UserPool userPool;
    private final ChatPool chatPool;
    private final ChatService chatService;
    private final MessageService messageService;

    private final SimpMessagingTemplate template;

    @MessageMapping("/start")
    public void start(User user, @Header("simpSessionId") String sessionId) {
        user.setSessionId(sessionId);
        Optional<Pair<User, User>> pair = userPool.addUser(user);

        if (pair.isPresent()) {
            List<User> users = List.of(
                    pair.get().getFirst(),
                    pair.get().getSecond()
            );

            var chat_passwords = chatService.createDialog(users);
            var chat = chat_passwords.getFirst();
            var passwords = chat_passwords.getSecond();

            log.info("Dialog created: {} with users: {}", chat.getId(), chat.getUserIds());

            for (User dialogUser : chat.getUsers()) {
                var responseMessage = new ResponseMessage(
                        chat.getId(),
                        dialogUser.getUserId(),
                        10,
                        passwords.get(dialogUser.getUserId()),
                        null
                );
                sendToSession(dialogUser.getSessionId(), "/dialog", responseMessage);
            }
        }
    }

    @MessageMapping("/start/authorised")
    public void startAuthorised() {
        throw new UnsupportedOperationException("authorised WS not implemented");
    }

    @MessageMapping("/message")
    public void send(InputMessage message) {
        messageService.save(message);
        var responseMessage = new ResponseMessage(message.chatId(), message.senderId(), 20, null, message.content());
        for (User user : chatPool.getById(message.chatId()).getUsers()) {
            sendToSession(user.getSessionId(), "/dialog", responseMessage);
        }
    }

    @MessageMapping("/stop")
    public void stop(InputMessage message) {
        var chatId = message.chatId();
        var responseMessage = new ResponseMessage(chatId, message.senderId(), 30, null, null);
        for (User user : chatPool.getById(chatId).getUsers()) {
            sendToSession(user.getSessionId(), "/dialog", responseMessage);
        }
        chatPool.remove(chatId);
        log.info("Dialog closed: {}", chatId);
    }

    private void sendToSession(String sessionId, String endpoint, Object payload) {
        template.convertAndSendToUser(sessionId, endpoint, payload, createHeaders(sessionId));
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        return headerAccessor.getMessageHeaders();
    }
}
