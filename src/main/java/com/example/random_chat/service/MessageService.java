package com.example.random_chat.service;


import com.example.random_chat.dao.MessageDao;
import com.example.random_chat.model.InputMessage;
import com.example.random_chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void save(InputMessage message) {
        MessageDao messageDao = new MessageDao();
        messageDao.setDialogUUID(UUID.fromString(message.getChatUUID()));
        messageDao.setUserUUID(UUID.fromString(message.getSenderUUID()));
        messageDao.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        messageDao.setContent(message.getContent());

        messageRepository.save(messageDao);
    }
}
