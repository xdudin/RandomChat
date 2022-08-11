package com.example.random_chat.model;

import lombok.Data;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public abstract class Chat {

    private Long id;

    public abstract Collection<User> getUsers();

    public Collection<Long> getUserIds() {
        return getUsers().stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
    }
}
