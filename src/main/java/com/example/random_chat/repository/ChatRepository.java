package com.example.random_chat.repository;

import com.example.random_chat.entity.ChatEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<ChatEntity, Long> {}
