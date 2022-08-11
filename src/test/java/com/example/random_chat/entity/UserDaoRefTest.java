package com.example.random_chat.entity;

import com.example.random_chat.repository.ChatRepository;
import com.example.random_chat.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@DataJdbcTest(properties = "debug=false")
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDaoRefTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

//    @Test
    public void chatParticipantPlayground() {

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("TestName1");
        userEntity1.setLanguageId((short) 1);
        userEntity1.setPassword("password".getBytes());

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("TestName2");
        userEntity2.setLanguageId((short) 1);
        userEntity2.setPassword("password".getBytes());

        System.out.println(userEntity1);
        System.out.println(userRepository.findAll());
        userRepository.saveAll(List.of(userEntity1, userEntity2));
        System.out.println(userRepository.findAll());
        System.out.println(userEntity1);

        Optional<UserEntity> userDao3 = userRepository.findById(1L);
        if (userDao3.isPresent()) {
            System.out.println(userDao3.get());
        } else {
            System.out.println("user not present");
        }

        System.out.println(userRepository.findAll());

        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setTypeId((short) 1);
        chatEntity.addParticipantById(userEntity1.getId());
        chatEntity.addParticipantById(userEntity2.getId());

        Optional<UserEntity> userDao4 = userRepository.findById(1L);
        Optional<UserEntity> userDao5 = userRepository.findById(2L);

        ChatEntity chatEntity1 = new ChatEntity();
        chatEntity1.setTypeId((short) 1);
        chatEntity1.addParticipantById(userDao4.get().getId());
        chatEntity1.addParticipantById(userDao5.get().getId());

        ChatEntity chatEntity2 = new ChatEntity();
        chatEntity2.setTypeId((short) 1);
        chatEntity2.addParticipantById(userDao4.get().getId());
        chatEntity2.addParticipantById(userDao5.get().getId());

        chatRepository.save(chatEntity1);
        chatRepository.save(chatEntity2);

        System.out.println(chatRepository.findAll());

        Optional<ChatEntity> chatDao3 = chatRepository.findById(1L);
        if (chatDao3.isPresent()) {
            System.out.println(chatDao3.get());
        } else {
            System.out.println("chat not present");
        }

        System.out.println(chatRepository.findAll());
    }
}