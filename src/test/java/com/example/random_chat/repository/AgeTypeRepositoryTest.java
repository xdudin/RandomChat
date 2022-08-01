package com.example.random_chat.repository;

import com.example.random_chat.entity.AgeTypeEntity;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJdbcTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AgeTypeRepositoryTest {

    @Autowired
    AgeTypeRepository ageTypeRepository;

//    @Test
    void findAllTest() {
        Assertions.assertThat(ageTypeRepository.findAll())
                .hasSize(6)
                .containsExactlyInAnyOrderElementsOf(getAgeTypeDaos());
    }

    private Iterable<AgeTypeEntity> getAgeTypeDaos() {
        return List.of(
                new AgeTypeEntity((short) 1, "14-18"),
                new AgeTypeEntity((short) 2, "16-20"),
                new AgeTypeEntity((short) 3, "18-24"),
                new AgeTypeEntity((short) 4, "22-26"),
                new AgeTypeEntity((short) 5, "24-30"),
                new AgeTypeEntity((short) 6, "30+")
        );
    }
}