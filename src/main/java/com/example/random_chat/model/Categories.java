package com.example.random_chat.model;

import com.example.random_chat.entity.AgeTypeEntity;
import com.example.random_chat.entity.ChatTypeEntity;
import com.example.random_chat.entity.GenderTypeEntity;
import com.example.random_chat.entity.LanguageTypeEntity;


public record Categories(Iterable<LanguageTypeEntity> language,
                         Iterable<GenderTypeEntity> gender,
                         Iterable<AgeTypeEntity> age,
                         Iterable<ChatTypeEntity> chatType) {}
