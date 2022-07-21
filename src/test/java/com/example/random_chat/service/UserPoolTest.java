package com.example.random_chat.service;

import com.example.random_chat.model.StrictPartnerSearcher;
import com.example.random_chat.model.User;
import com.example.random_chat.model.UserPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

import static com.example.random_chat.service.Users.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserPoolTest {

    private UserPool userPool;

    @BeforeEach
    public void beforeAll() {
        userPool = new UserPool(new StrictPartnerSearcher());
    }

    @Test
    public void languageBuildPairs() {
        simpleMatchTest(EN___EN___12, EN___EN___13);
    }

    @Test
    public void simpleBuildPairs() {
        simpleMatchTest(RU___RU___1, RU___RU___2);
    }

    @Test
    public void ageBuildPairs() {
        simpleMatchTest(RU18__RU18__4, RU18__RU18__5);
    }

    @Test
    public void genderBuildPairs() {
        simpleMatchTest(RU_M_RU_F_6, RU_F_RU_M_8);
    }

    @Test
    public void ageGenderBuildPairs() {
        simpleMatchTest(RU20M_RU18F_9, RU18F_RU20M_11);
    }

    @Test
    public void complexLanguageBuildPairs() {
        complexBuildPairs(EN___EN___12, RU___RU___1, EN___EN___13);
    }

    @Test
    public void complexGenderBuildPairs() {
        complexBuildPairs(RU_M_RU_F_6, RU_M_RU_F_7, RU_F_RU_M_8);
    }

    @Test
    public void complexGeneralBuildPairs() {
        complexBuildPairs(RU20M_RU18F_9, RU18F_RU18M_10, RU18F_RU20M_11);
    }

    @Test
    public void listBuildPairs() {
        List<User> users = List.of(
                RU20M_RU18F_9, // 1 pair
                RU18F_RU18M_10, // maybe 2 pair
                RU18F_RU20M_11, // 1 pair
                RU_F_RU_M_8, // maybe 2 pair
                RU_M_RU_F_7 // 2 pair
        );

        Optional<Pair<User, User>> userUserPair = Optional.empty();
        for (User user : users) {
            userUserPair = userPool.addUser(user);
        }
        assertTrue(userUserPair.isPresent());
        assertFalse(userPool.isEmpty());

        userUserPair = userPool.addUser(RU___RU___3);
        assertTrue(userUserPair.isPresent());
        assertSame(userUserPair.get().getFirst(), RU___RU___3);
        assertTrue(userPool.isEmpty());
    }

    private void simpleMatchTest(User u1, User u2) {
        Optional<Pair<User, User>> pair1 = userPool.addUser(u1);
        assertTrue(pair1.isEmpty());

        Optional<Pair<User, User>> pair2 = userPool.addUser(u2);
        assertTrue(pair2.isPresent());
        assertSame(pair2.get().getFirst(), u2);
        assertSame(pair2.get().getSecond(), u1);
        assertTrue(userPool.isEmpty());
    }

    private void complexBuildPairs(User u1, User u2, User u3) {
        Optional<Pair<User, User>> pair1 = userPool.addUser(u1);
        assertTrue(pair1.isEmpty());

        Optional<Pair<User, User>> pair2 = userPool.addUser(u2);
        assertTrue(pair2.isEmpty());

        Optional<Pair<User, User>> pair3 = userPool.addUser(u3);
        assertTrue(pair3.isPresent());
        assertSame(pair3.get().getFirst(), u3);
        assertFalse(userPool.isEmpty());
    }
}
