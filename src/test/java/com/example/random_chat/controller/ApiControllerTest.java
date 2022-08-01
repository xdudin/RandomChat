package com.example.random_chat.controller;

import com.example.random_chat.entity.AgeTypeEntity;
import com.example.random_chat.entity.ChatTypeEntity;
import com.example.random_chat.entity.GenderTypeEntity;
import com.example.random_chat.entity.LanguageTypeEntity;
import com.example.random_chat.repository.AgeTypeRepository;
import com.example.random_chat.repository.ChatTypeRepository;
import com.example.random_chat.repository.GenderTypeRepository;
import com.example.random_chat.repository.LanguageTypeRepository;
import com.example.random_chat.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiControllerTest {

    ApiController apiController;

    @BeforeEach
    void setup() {
        LanguageTypeRepository languageTypeRepository = Mockito.mock(LanguageTypeRepository.class);
        GenderTypeRepository genderTypeRepository = Mockito.mock(GenderTypeRepository.class);
        AgeTypeRepository ageTypeRepository = Mockito.mock(AgeTypeRepository.class);
        ChatTypeRepository chatTypeRepository = Mockito.mock(ChatTypeRepository.class);

        Mockito.when(languageTypeRepository.findAll()).thenReturn(getLanguageTypeEntities());
        Mockito.when(genderTypeRepository.findAll()).thenReturn(getGenderTypeEntities());
        Mockito.when(ageTypeRepository.findAll()).thenReturn(getAgeTypeEntities());
        Mockito.when(chatTypeRepository.findAll()).thenReturn(getChatTypeEntities());

        CategoryService categoryService = new CategoryService(
                languageTypeRepository, genderTypeRepository, ageTypeRepository, chatTypeRepository
        );

        apiController = new ApiController(categoryService);
    }

    @Test
    void getCategories() {
        Iterator<LanguageTypeEntity> languageTypeDaoIterator = apiController.getCategories().language().iterator();
        assertEquals(languageTypeDaoIterator.next().getCode(), "en");
        assertEquals(languageTypeDaoIterator.next().getCode(), "cs");

        Iterator<GenderTypeEntity> genderTypeDaoIterator = apiController.getCategories().gender().iterator();
        assertEquals(genderTypeDaoIterator.next().getGender(), "male");

        Iterator<AgeTypeEntity> ageTypeDaoIterator = apiController.getCategories().age().iterator();
        assertEquals(ageTypeDaoIterator.next().getAge(), "14-18");
        assertEquals(ageTypeDaoIterator.next().getAge(), "16-20");
    }

    private Iterable<LanguageTypeEntity> getLanguageTypeEntities() {
        LanguageTypeEntity languageTypeEntity1 = new LanguageTypeEntity((short) 1, "English", "en");
        LanguageTypeEntity languageTypeEntity2 = new LanguageTypeEntity((short) 20, "Czech", "cs");
        return List.of(languageTypeEntity1, languageTypeEntity2);
    }

    private Iterable<GenderTypeEntity> getGenderTypeEntities() {
        GenderTypeEntity genderTypeEntity = new GenderTypeEntity((short) 1, "male");
        return List.of(genderTypeEntity);
    }

    private Iterable<AgeTypeEntity> getAgeTypeEntities() {
        AgeTypeEntity ageTypeEntity1 = new AgeTypeEntity((short) 1, "14-18");
        AgeTypeEntity ageTypeEntity2 = new AgeTypeEntity((short) 2, "16-20");
        return List.of(ageTypeEntity1, ageTypeEntity2);
    }

    private Iterable<ChatTypeEntity> getChatTypeEntities() {
        ChatTypeEntity chatTypeEntity1 = new ChatTypeEntity((short) 1, "normal");
        ChatTypeEntity chatTypeEntity2 = new ChatTypeEntity((short) 1, "flirtation");
        ChatTypeEntity chatTypeEntity3 = new ChatTypeEntity((short) 1, "language");
        return List.of(chatTypeEntity1, chatTypeEntity2, chatTypeEntity3);
    }

}