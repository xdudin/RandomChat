package com.example.random_chat.service;

import com.example.random_chat.entity.ChatEntity;
import com.example.random_chat.entity.UserEntity;
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

    public void save(Chat chat, Collection<UserEntity> users) {
        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setUuid(UUID.fromString(chat.getUUID()));
        chatEntity.setTypeId((short) 1);
        chatEntity.addAllParticipants(users);

        chatRepository.save(chatEntity);
    }
}
