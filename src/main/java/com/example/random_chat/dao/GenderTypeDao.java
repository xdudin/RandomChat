package com.example.random_chat.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(name = "gender")
public class GenderTypeDao {

    @Id
    Short id;
    String gender;
}
