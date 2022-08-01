package com.example.random_chat.repository;

import com.example.random_chat.entity.ChatEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChatRepository extends CrudRepository<ChatEntity, UUID> {}
