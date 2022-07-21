package com.example.random_chat.repository;

import com.example.random_chat.dao.GenderTypeDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@DataJdbcTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GenderTypeRepositoryTest {

    @Autowired
    GenderTypeRepository genderTypeRepository;

//    @Test
    void findAllTest() {
        Assertions.assertThat(genderTypeRepository.findAll())
                .hasSize(2)
                .containsExactlyInAnyOrderElementsOf(getGenderTypeDaos());
    }

    private Iterable<GenderTypeDao> getGenderTypeDaos() {
        return List.of(
                new GenderTypeDao((short) 1, "male"),
                new GenderTypeDao((short) 2, "female")
        );
    }
}