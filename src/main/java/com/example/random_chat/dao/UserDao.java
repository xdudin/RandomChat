package com.example.random_chat.dao;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "user")
@JsonIgnoreProperties({"id", "new"})
public class UserDao implements Persistable<UUID> {

    @Id
    private UUID uuid;

    private String name;
    @Column("age_id")
    private Short ageId;
    @Column("gender_id")
    private Short genderId;
    @Column("language_id")
    private Short languageId;

    @Override
    public UUID getId() {
        return uuid;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
