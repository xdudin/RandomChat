package com.example.random_chat.repository;

import com.example.random_chat.dao.UserDao;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserDao, UUID> {}
