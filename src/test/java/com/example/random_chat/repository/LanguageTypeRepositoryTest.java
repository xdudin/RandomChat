package com.example.random_chat.repository;

import com.example.random_chat.entity.LanguageTypeEntity;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@DataJdbcTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LanguageTypeRepositoryTest {

    @Autowired
    LanguageTypeRepository languageTypeRepository;

//    @Test
    void findAllTest() {
        Assertions.assertThat(languageTypeRepository.findAll())
                .hasSize(6)
                .containsExactlyInAnyOrderElementsOf(getLanguageTypeDaos());
    }

    private Iterable<LanguageTypeEntity> getLanguageTypeDaos() {
        return List.of(
                new LanguageTypeEntity((short) 1, "English", "en"),
                new LanguageTypeEntity((short) 20, "Czech", "cs"),
                new LanguageTypeEntity((short) 23, "German", "de"),
                new LanguageTypeEntity((short) 34, "French", "fr"),
                new LanguageTypeEntity((short) 51, "Italian", "it"),
                new LanguageTypeEntity((short) 94, "Russian", "ru")
        );
    }
}