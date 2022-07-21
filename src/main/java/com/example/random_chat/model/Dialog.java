package com.example.random_chat.model;

import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Value
public class Dialog implements Chat {

    String uuid = UUID.randomUUID().toString();

    User user1;
    User user2;

    @Override
    public Collection<User> getUsers() {
        return List.of(user1, user2);
    }

    @Override
    public String getUUID() {
        return uuid;
    }
}
