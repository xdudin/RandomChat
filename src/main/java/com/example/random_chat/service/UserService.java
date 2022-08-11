package com.example.random_chat.service;

import com.example.random_chat.entity.UserEntity;
import com.example.random_chat.model.User;
import com.example.random_chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryService categoryService;

    public void saveNew(User user, String password) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(user.getName());
        userEntity.setLanguageId(categoryService.getLanguageId(user.getLanguageCode()));
        userEntity.setGenderId(categoryService.getGenderId(user.getUserAttributes().getGender()));
        userEntity.setAgeId(categoryService.getAgeId(user.getUserAttributes().getAge()));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(password).getBytes());

        userRepository.save(userEntity);
        user.setUserId(userEntity.getId());
        user.setUserId(userEntity.getId());
    }
}
