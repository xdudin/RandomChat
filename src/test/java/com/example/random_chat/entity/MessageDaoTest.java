package com.example.random_chat.entity;

import com.example.random_chat.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;


@DataJdbcTest(properties = "debug=false")
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MessageDaoTest {

    @Autowired
    MessageRepository messageRepository;

//    @Test
    public void messagePlayground() {

        System.out.println(messageRepository.findAll());

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setChatId(1L);
        messageEntity.setUserId(2L);
        messageEntity.setContent("hello save");
        messageEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        messageRepository.save(messageEntity);

        System.out.println(messageRepository.findAll());
    }
}
