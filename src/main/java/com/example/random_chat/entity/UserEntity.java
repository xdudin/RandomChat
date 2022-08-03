package com.example.random_chat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    private Long id;

    private String name;
    @Column("language_id")
    private Short languageId;
    @Column("gender_id")
    private Short genderId;
    @Column("age_id")
    private Short ageId;
    private String password;
}
