package com.example.random_chat.repository;

import com.example.random_chat.dao.MessageDao;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageDao, Long> {}
