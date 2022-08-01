package com.example.random_chat.service;


import com.example.random_chat.entity.MessageEntity;
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
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setDialogUUID(UUID.fromString(message.getChatUUID()));
        messageEntity.setUserUUID(UUID.fromString(message.getSenderUUID()));
        messageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        messageEntity.setContent(message.getContent());

        messageRepository.save(messageEntity);
    }
}
