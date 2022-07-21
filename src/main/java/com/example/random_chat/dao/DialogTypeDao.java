package com.example.random_chat.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "dialog_type")
public class DialogTypeDao {

    @Id
    Short id;
    String name;
}

