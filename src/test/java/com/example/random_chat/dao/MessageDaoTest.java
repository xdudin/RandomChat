package com.example.random_chat.dao;

import com.example.random_chat.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.util.UUID;


@DataJdbcTest(properties = "debug=true")
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MessageDaoTest {

    @Autowired
    MessageRepository messageRepository;

//    @Test
    public void messagePlayground() {

        System.out.println(messageRepository.findAll());

        MessageDao messageDao = new MessageDao();
        messageDao.setDialogUUID(UUID.fromString("794dfd02-65b9-4a6d-8e30-cfc40b9cdc02"));
        messageDao.setUserUUID(UUID.fromString("1a88cce1-3738-43fb-a142-cfb26672e018"));
        messageDao.setContent("hello save");
        messageDao.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        messageRepository.save(messageDao);

        System.out.println(messageRepository.findAll());
    }
}
