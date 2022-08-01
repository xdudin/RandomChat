package com.example.random_chat.entity;

import com.example.random_chat.repository.ChatRepository;
import com.example.random_chat.repository.UserRepository;
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

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUuid(UUID.fromString("52131bcc-af5f-4730-bc21-b9710f736900"));
        userEntity1.setName("TestName1");
        userEntity1.setLanguageId((short) 1);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setUuid(UUID.fromString("eb4e3fb4-eb5f-43cd-8ef3-317c69df5a85"));
        userEntity2.setName("TestName2");
        userEntity2.setLanguageId((short) 1);

        userRepository.saveAll(List.of(userEntity1, userEntity2));

        Optional<UserEntity> userDao3 = userRepository.findById(UUID.fromString("eb4e3fb4-eb5f-43cd-8ef3-317c69df5a85"));
        if (userDao3.isPresent()) {
            System.out.println(userDao3.get());
        } else {
            System.out.println("user not present");
        }

        System.out.println(userRepository.findAll());

        ChatEntity chatEntity = new ChatEntity();
        chatEntity.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab3"));
        chatEntity.setTypeId((short) 1);
        chatEntity.addParticipant(userEntity1);
        chatEntity.addParticipant(userEntity2);

        Optional<UserEntity> userDao4 = userRepository.findById(UUID.fromString("66eb334f-2190-4b33-8406-24889aae4ceb"));
        Optional<UserEntity> userDao5 = userRepository.findById(UUID.fromString("d9cf3d94-674a-4d58-a0b4-97249af3a823"));

        ChatEntity chatEntity1 = new ChatEntity();
        chatEntity1.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab3"));
        chatEntity1.setTypeId((short) 1);
        chatEntity1.addParticipant(userDao4.get());
        chatEntity1.addParticipant(userDao5.get());

        ChatEntity chatEntity2 = new ChatEntity();
        chatEntity2.setUuid(UUID.fromString("288c8c6b-a0b1-48b4-b87b-c85bde6acab4"));
        chatEntity2.setTypeId((short) 1);
        chatEntity2.addParticipant(userDao4.get());
        chatEntity2.addParticipant(userDao5.get());

        chatRepository.save(chatEntity1);
        chatRepository.save(chatEntity2);

        System.out.println(chatRepository.findAll());

        Optional<ChatEntity> chatDao3 = chatRepository.findById(UUID.fromString("7b1e7671-bfc4-4668-b20c-578b1ae5dbd0"));
        if (chatDao3.isPresent()) {
            System.out.println(chatDao3.get());
        } else {
            System.out.println("chat not present");
        }

        System.out.println(chatRepository.findAll());


    }
}