package com.example.random_chat.service;

import com.example.random_chat.entity.AgeTypeEntity;
import com.example.random_chat.entity.GenderTypeEntity;
import com.example.random_chat.entity.LanguageTypeEntity;
import com.example.random_chat.model.Categories;
import com.example.random_chat.repository.AgeTypeRepository;
import com.example.random_chat.repository.ChatTypeRepository;
import com.example.random_chat.repository.GenderTypeRepository;
import com.example.random_chat.repository.LanguageTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final Categories categories;

    public CategoryService(LanguageTypeRepository languageTypeRepository,
                           GenderTypeRepository genderTypeRepository,
                           AgeTypeRepository ageTypeRepository,
                           ChatTypeRepository chatTypeRepository) {
        categories = new Categories(
                languageTypeRepository.findAll(),
                genderTypeRepository.findAll(),
                ageTypeRepository.findAll(),
                chatTypeRepository.findAll()
        );
    }

    public Categories getCategories() {
        return categories;
    }

    public Short getLanguageId(String languageCode) {
        if (languageCode == null) {
            return null;
        }
        for (LanguageTypeEntity languageTypeEntity : categories.language()) {
            if (languageTypeEntity.getCode().equals(languageCode)) {
                return languageTypeEntity.getId();
            }
        }
        throw new RuntimeException("no such category: " + languageCode);
    }

    public Short getGenderId(String gender) {
        if (gender == null) {
            return null;
        }
        for (GenderTypeEntity genderTypeEntity : categories.gender()) {
            if (genderTypeEntity.getGender().equals(gender)) {
                return genderTypeEntity.getId();
            }
        }
        throw new RuntimeException("no such category: " + gender);
    }

    public Short getAgeId(String age) {
        if (age == null) {
            return null;
        }
        for (AgeTypeEntity ageTypeEntity : categories.age()) {
            if (ageTypeEntity.getAge().equals(age)) {
                return ageTypeEntity.getId();
            }
        }
        throw new RuntimeException("no such category: " + age);
    }
}
