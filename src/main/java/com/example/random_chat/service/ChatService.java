package com.example.random_chat.service;

import com.example.random_chat.entity.ChatEntity;
import com.example.random_chat.model.Chat;
import com.example.random_chat.model.ChatPool;
import com.example.random_chat.model.Dialog;
import com.example.random_chat.model.User;
import com.example.random_chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserService userService;
    private final ChatPool chatPool;

    public void save(Chat chat) {
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setId(chat.getId());
        chatEntity.setTypeId((short) 1);
        chatEntity.addAllParticipantsByIds(
                chat.getUsers().stream()
                        .map(User::getUserId)
                        .collect(Collectors.toList())
        );

        chatRepository.save(chatEntity);
        chat.setId(chatEntity.getId());
    }

    @Transactional
    public Pair<Chat, Map<Long, String>> createDialog(List<User> users) {
        Map<Long, String> passwords = new HashMap<>();
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        for (User newUser : users) {
            String password = passwordGenerator.genPassword();
            userService.saveNew(newUser, password);
            passwords.put(newUser.getUserId(), password);
        }

        Chat chat = new Dialog(users);
        save(chat);
        chatPool.addChat(chat);

        return Pair.of(chat, passwords);
    }
}
