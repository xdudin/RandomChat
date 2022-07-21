package com.example.random_chat.controller;

import com.example.random_chat.dao.AgeTypeDao;
import com.example.random_chat.dao.GenderTypeDao;
import com.example.random_chat.dao.LanguageTypeDao;
import com.example.random_chat.repository.AgeTypeRepository;
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

        Mockito.when(languageTypeRepository.findAll()).thenReturn(getLanguageTypeDaos());
        Mockito.when(genderTypeRepository.findAll()).thenReturn(getGenderTypeDaos());
        Mockito.when(ageTypeRepository.findAll()).thenReturn(getAgeTypeDaos());

        CategoryService categoryService = new CategoryService(languageTypeRepository, genderTypeRepository, ageTypeRepository);

        apiController = new ApiController(categoryService);
    }

    @Test
    void getCategories() {
        Iterator<LanguageTypeDao> languageTypeDaoIterator = apiController.getCategories().getLanguage().iterator();
        assertEquals(languageTypeDaoIterator.next().getCode(), "en");
        assertEquals(languageTypeDaoIterator.next().getCode(), "cs");

        Iterator<GenderTypeDao> genderTypeDaoIterator = apiController.getCategories().getGender().iterator();
        assertEquals(genderTypeDaoIterator.next().getGender(), "male");

        Iterator<AgeTypeDao> ageTypeDaoIterator = apiController.getCategories().getAge().iterator();
        assertEquals(ageTypeDaoIterator.next().getAge(), "14-18");
        assertEquals(ageTypeDaoIterator.next().getAge(), "16-20");
    }

    private Iterable<LanguageTypeDao> getLanguageTypeDaos() {
        LanguageTypeDao languageTypeDao1 = new LanguageTypeDao((short) 1, "English", "en");
        LanguageTypeDao languageTypeDao2 = new LanguageTypeDao((short) 20, "Czech", "cs");
        return List.of(languageTypeDao1, languageTypeDao2);
    }

    private Iterable<GenderTypeDao> getGenderTypeDaos() {
        GenderTypeDao genderTypeDao = new GenderTypeDao((short) 1, "male");
        return List.of(genderTypeDao);
    }

    private Iterable<AgeTypeDao> getAgeTypeDaos() {
        AgeTypeDao ageTypeDao1 = new AgeTypeDao((short) 1, "14-18");
        AgeTypeDao ageTypeDao2 = new AgeTypeDao((short) 2, "16-20");
        return List.of(ageTypeDao1, ageTypeDao2);
    }
}