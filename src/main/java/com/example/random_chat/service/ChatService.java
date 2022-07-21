package com.example.random_chat.service;

import com.example.random_chat.dao.ChatDao;
import com.example.random_chat.dao.UserDao;
import com.example.random_chat.model.Chat;
import com.example.random_chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public void save(Chat chat, Collection<UserDao> users) {
        ChatDao chatDao = new ChatDao();
        chatDao.setUuid(UUID.fromString(chat.getUUID()));
        chatDao.setTypeId((short) 1);
        chatDao.addAllParticipants(users);

        chatRepository.save(chatDao);
    }
}
