package com.example.random_chat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("message")
public class MessageEntity {

    @Id
    private Long id;

    @Column("chat_id")
    private Long chatId;
    @Column("user_id")
    private Long userId;
    @Column("created_at")
    private Timestamp createdAt;
    private String content;
}
