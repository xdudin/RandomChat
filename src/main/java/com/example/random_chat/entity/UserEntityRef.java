package com.example.random_chat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@Table("dialog_participant")
public class UserEntityRef {

    @Column("user_uuid")
    private UUID userUUID;
}
