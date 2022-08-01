package com.example.random_chat.repository;

import com.example.random_chat.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {}
