package com.example.random_chat.service;

import com.example.random_chat.entity.UserEntity;
import com.example.random_chat.model.User;
import com.example.random_chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryService categoryService;

    public UserEntity save(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(UUID.fromString(user.getUserUUID().toString()));
        userEntity.setName(user.getName());
        userEntity.setLanguageId(categoryService.getLanguageId(user.getLanguageCode()));
        userEntity.setGenderId(categoryService.getGenderId(user.getUserAttributes().getGender()));
        userEntity.setAgeId(categoryService.getAgeId(user.getUserAttributes().getAge()));

        userRepository.save(userEntity);
        return userEntity;
    }
}
