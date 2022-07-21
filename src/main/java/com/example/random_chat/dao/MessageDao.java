package com.example.random_chat.dao;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Table("message")
public class MessageDao {

    @Id
    private Long id;

    @Column("dialog_uuid")
    private UUID dialogUUID;
    @Column("user_uuid")
    private UUID userUUID;
    @Column("created_at")
    private Timestamp createdAt;
    private String content;
}
