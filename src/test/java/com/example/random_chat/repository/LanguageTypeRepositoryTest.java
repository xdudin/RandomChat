package com.example.random_chat.repository;

import com.example.random_chat.dao.LanguageTypeDao;
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
class LanguageTypeRepositoryTest {

    @Autowired
    LanguageTypeRepository languageTypeRepository;

//    @Test
    void findAllTest() {
        Assertions.assertThat(languageTypeRepository.findAll())
                .hasSize(6)
                .containsExactlyInAnyOrderElementsOf(getLanguageTypeDaos());
    }

    private Iterable<LanguageTypeDao> getLanguageTypeDaos() {
        return List.of(
                new LanguageTypeDao((short) 1, "English", "en"),
                new LanguageTypeDao((short) 20, "Czech", "cs"),
                new LanguageTypeDao((short) 23, "German", "de"),
                new LanguageTypeDao((short) 34, "French", "fr"),
                new LanguageTypeDao((short) 51, "Italian", "it"),
                new LanguageTypeDao((short) 94, "Russian", "ru")
        );
    }
}