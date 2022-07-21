package com.example.random_chat.dao;

import com.example.random_chat.repository.ChatRepository;
import com.example.random_chat.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DataJdbcTest(properties = "debug=true")
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDaoRefTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

//    @Test
    public void chatParticipantPlayground() {

        UserDao userDao1 = new UserDao();
        userDao1.setUuid(UUID.fromString("52131bcc-af5f-4730-bc21-b9710f736900"));
        userDao1.setName("TestName1");
        userDao1.setLanguageId((short) 1);

        UserDao userDao2 = new UserDao();
        userDao2.setUuid(UUID.fromString("eb4e3fb4-eb5f-43cd-8ef3-317c69df5a85"));
        userDao2.setName("TestName2");
        userDao2.setLanguageId((short) 1);

        userRepository.saveAll(List.of(userDao1, userDao2));

        Optional<UserDao> userDao3 = userRepository.findById(UUID.fromString("eb4e3fb4-eb5f-43cd-8ef3-317c69df5a85"));
        if (userDao3.isPresent()) {
            System.out.println(userDao3.get());
        } else {
            System.out.println("user not present");
        }

        System.out.println(userRepository.findAll());

        ChatDao chatDao = new ChatDao();
        chatDao.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab3"));
        chatDao.setTypeId((short) 1);
        chatDao.addParticipant(userDao1);
        chatDao.addParticipant(userDao2);

        Optional<UserDao> userDao4 = userRepository.findById(UUID.fromString("66eb334f-2190-4b33-8406-24889aae4ceb"));
        Optional<UserDao> userDao5 = userRepository.findById(UUID.fromString("d9cf3d94-674a-4d58-a0b4-97249af3a823"));

        ChatDao chatDao1 = new ChatDao();
        chatDao1.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab3"));
        chatDao1.setTypeId((short) 1);
        chatDao1.addParticipant(userDao4.get());
        chatDao1.addParticipant(userDao5.get());

        ChatDao chatDao2 = new ChatDao();
        chatDao2.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab4"));
        chatDao2.setTypeId((short) 1);
        chatDao2.addParticipant(userDao4.get());
        chatDao2.addParticipant(userDao5.get());

        chatRepository.save(chatDao1);
        chatRepository.save(chatDao2);

        System.out.println(chatRepository.findAll());

        Optional<ChatDao> chatDao3 = chatRepository.findById(UUID.fromString("7b1e7671-bfc4-4668-b20c-578b1ae5dbd0"));
        if (chatDao3.isPresent()) {
            System.out.println(chatDao3.get());
        } else {
            System.out.println("chat not present");
        }

        System.out.println(chatRepository.findAll());


    }
}