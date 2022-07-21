package com.example.random_chat.model;

import com.example.random_chat.dao.AgeTypeDao;
import com.example.random_chat.dao.GenderTypeDao;
import com.example.random_chat.dao.LanguageTypeDao;
import lombok.Value;

@Value
public class Categories {

    Iterable<LanguageTypeDao> language;
    Iterable<GenderTypeDao> gender;
    Iterable<AgeTypeDao> age;
}
