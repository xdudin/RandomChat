package com.example.random_chat.repository;

import com.example.random_chat.entity.GenderTypeEntity;
import org.assertj.core.api.Assertions;
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

    private Iterable<GenderTypeEntity> getGenderTypeDaos() {
        return List.of(
                new GenderTypeEntity((short) 1, "male"),
                new GenderTypeEntity((short) 2, "female")
        );
    }
}