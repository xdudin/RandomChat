package com.example.random_chat.model;

import lombok.Data;

@Data
public class User {

    private Long userId;
    private String sessionId;
    private final String name;
    private final String languageCode;

    private final UserAttributes userAttributes;
    private final UserAttributes targetAttributes;
}
