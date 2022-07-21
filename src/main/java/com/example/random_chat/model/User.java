package com.example.random_chat.model;

import lombok.Data;

import java.util.UUID;


@Data
public class User {

    private final String name;
    private final UUID userUUID = UUID.randomUUID();
    private String sessionId;
    private final String languageCode;

    private final UserAttributes userAttributes;
    private final UserAttributes targetAttributes;
}
