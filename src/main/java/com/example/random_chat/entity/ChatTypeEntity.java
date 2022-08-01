package com.example.random_chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "dialog_type")
public class ChatTypeEntity {

    @Id
    Short id;
    String name;
}

