package com.example.random_chat.repository;

import com.example.random_chat.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {}
