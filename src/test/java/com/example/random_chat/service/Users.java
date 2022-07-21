package com.example.random_chat.service;

import com.example.random_chat.model.User;
import com.example.random_chat.model.UserAttributes;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Users {

    public static final User RU___RU___1 = new User("name1", "ru",
            UserAttributes.builder().build(),
            UserAttributes.builder().build());

    public static final User RU___RU___2 = new User("name2", "ru",
            UserAttributes.builder().build(),
            UserAttributes.builder().build());

    public static final User RU___RU___3 = new User("name3", "ru",
            UserAttributes.builder().build(),
            UserAttributes.builder().build());

    public static final User RU18__RU18__4 = new User("name4", "ru",
            UserAttributes.builder().age("18").build(),
            UserAttributes.builder().age("18").build());

    public static final User RU18__RU18__5 = new User("name5", "ru",
            UserAttributes.builder().age("18").build(),
            UserAttributes.builder().age("18").build());

    public static final User RU_M_RU_F_6 = new User("name6", "ru",
            UserAttributes.builder().gender("M").build(),
            UserAttributes.builder().gender("F").build());

    public static final User RU_M_RU_F_7 = new User("name7", "ru",
            UserAttributes.builder().gender("M").build(),
            UserAttributes.builder().gender("F").build());

    public static final User RU_F_RU_M_8 = new User("name8", "ru",
            UserAttributes.builder().gender("F").build(),
            UserAttributes.builder().gender("M").build());

    public static final User RU20M_RU18F_9 = new User("name9", "ru",
            UserAttributes.builder().gender("M").age("20").build(),
            UserAttributes.builder().gender("F").age("18").build());

    public static final User RU18F_RU18M_10 = new User("name10", "ru",
            UserAttributes.builder().gender("F").age("18").build(),
            UserAttributes.builder().gender("M").age("18").build());

    public static final User RU18F_RU20M_11 = new User("name11", "ru",
            UserAttributes.builder().gender("F").age("18").build(),
            UserAttributes.builder().gender("M").age("20").build());

    public static final User EN___EN___12 = new User("name1", "en",
            UserAttributes.builder().build(),
            UserAttributes.builder().build());

    public static final User EN___EN___13 = new User("name1", "en",
            UserAttributes.builder().build(),
            UserAttributes.builder().build());

    public static Collection<User> getUsers() {
        return List.of(
                RU___RU___1, RU___RU___2, RU___RU___3, RU18__RU18__4,
                RU18__RU18__5, RU_M_RU_F_6, RU_M_RU_F_7, RU_F_RU_M_8,
                RU20M_RU18F_9, RU18F_RU18M_10, RU18F_RU20M_11, EN___EN___12,
                EN___EN___13
        );
    }

    static {
        getUsers().forEach(user -> user.setSessionId(UUID.randomUUID().toString()));
    }
}
