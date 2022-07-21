package com.example.random_chat.repository;

import com.example.random_chat.dao.ChatDao;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChatRepository extends CrudRepository<ChatDao, UUID> {}
