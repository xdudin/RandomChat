package com.example.random_chat.service;

import com.example.random_chat.dao.UserDao;
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

    public UserDao save(User user) {
        UserDao userDao = new UserDao();
        userDao.setUuid(UUID.fromString(user.getUserUUID().toString()));
        userDao.setName(user.getName());
        userDao.setLanguageId(categoryService.getLanguageId(user.getLanguageCode()));
        userDao.setGenderId(categoryService.getGenderId(user.getUserAttributes().getGender()));
        userDao.setAgeId(categoryService.getAgeId(user.getUserAttributes().getAge()));

        userRepository.save(userDao);
        return userDao;
    }
}
