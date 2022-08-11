package com.example.random_chat.model;

public record InputMessage(
        Long chatId, Long senderId, String content
) {
}
