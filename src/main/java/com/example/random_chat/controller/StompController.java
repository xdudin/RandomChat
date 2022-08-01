package com.example.random_chat.controller;

import com.example.random_chat.entity.UserEntity;
import com.example.random_chat.model.Chat;
import com.example.random_chat.model.Dialog;
import com.example.random_chat.model.InputMessage;
import com.example.random_chat.model.ResponseMessage;
import com.example.random_chat.model.User;
import com.example.random_chat.model.ChatPool;
import com.example.random_chat.service.ChatService;
import com.example.random_chat.service.MessageService;
import com.example.random_chat.model.UserPool;
import com.example.random_chat.service.UserService;
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
    private final UserService userService;
    private final ChatService chatService;
    private final MessageService messageService;

    private final SimpMessagingTemplate template;

    @MessageMapping("/start")
    public void start(User user, @Header("simpSessionId") String sessionId) {
        user.setSessionId(sessionId);
        Optional<Pair<User, User>> pair = userPool.addUser(user);
        if (pair.isPresent()) {
            User user1 = pair.get().getFirst();
            User user2 = pair.get().getSecond();
            Chat dialog = new Dialog(user1, user2);
            UserEntity userEntity1 = userService.save(user1);
            UserEntity userEntity2 = userService.save(user2);
            log.info("User created: {}", user1.getUserUUID());
            log.info("User created: {}", user2.getUserUUID());
            chatPool.addChat(dialog);
            chatService.save(dialog, List.of(userEntity1, userEntity2));
            log.info("Dialog created: {}", dialog.getUUID());
            for (User dialogUser : dialog.getUsers()) {
                var responseMessage = new ResponseMessage(dialog.getUUID(), dialogUser.getUserUUID().toString(), 10, null, null);
                template.convertAndSendToUser(dialogUser.getSessionId(), "/dialog", responseMessage, createHeaders(dialogUser.getSessionId()));
            }
        }
    }

    @MessageMapping("/message")
    public void send(InputMessage message) {
        messageService.save(message);
        var responseMessage = new ResponseMessage(message.getChatUUID(), message.getSenderUUID(), 20, null, message.getContent());
        for (User user : chatPool.getByUUID(message.getChatUUID()).getUsers()) {
            template.convertAndSendToUser(user.getSessionId(), "/dialog", responseMessage, createHeaders(user.getSessionId()));
        }
    }

    @MessageMapping("/stop")
    public void stop(InputMessage message) {
        var chatUUID = message.getChatUUID();
        var responseMessage = new ResponseMessage(chatUUID, message.getSenderUUID(), 30, null, null);
        for (User user : chatPool.getByUUID(chatUUID).getUsers()) {
            template.convertAndSendToUser(user.getSessionId(), "/dialog", responseMessage, createHeaders(user.getSessionId()));
        }
        chatPool.remove(chatUUID);
        log.info("Dialog closed: {}", chatUUID);
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        return headerAccessor.getMessageHeaders();
    }
}
