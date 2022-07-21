package com.example.random_chat.repository;

import com.example.random_chat.dao.ChatDao;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<ChatDao, Long> {}
