package com.example.random_chat.service;


import com.example.random_chat.entity.MessageEntity;
import com.example.random_chat.model.InputMessage;
import com.example.random_chat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void save(InputMessage message) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setChatId(message.chatId());
        messageEntity.setUserId(message.senderId());
        messageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        messageEntity.setContent(message.content());

        messageRepository.save(messageEntity);
    }
}
