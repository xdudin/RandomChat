package com.example.random_chat.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "language")
public class LanguageTypeDao {

    @Id
    Short id;
    String name;
    String code;
}
