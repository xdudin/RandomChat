package com.example.random_chat.service;

import com.example.random_chat.dao.AgeTypeDao;
import com.example.random_chat.dao.GenderTypeDao;
import com.example.random_chat.dao.LanguageTypeDao;
import com.example.random_chat.model.Categories;
import com.example.random_chat.repository.AgeTypeRepository;
import com.example.random_chat.repository.GenderTypeRepository;
import com.example.random_chat.repository.LanguageTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final Categories categories;

    public CategoryService(LanguageTypeRepository languageTypeRepository,
                           GenderTypeRepository genderTypeRepository,
                           AgeTypeRepository ageTypeRepository) {
        categories = new Categories(
                languageTypeRepository.findAll(),
                genderTypeRepository.findAll(),
                ageTypeRepository.findAll()
        );
    }

    public Categories getCategories() {
        return categories;
    }

    public Short getLanguageId(String languageCode) {
        if (languageCode == null) {
            return null;
        }
        for (LanguageTypeDao languageTypeDao : categories.getLanguage()) {
            if (languageTypeDao.getCode().equals(languageCode)) {
                return languageTypeDao.getId();
            }
        }
        throw new RuntimeException("no such category: " + languageCode);
    }

    public Short getGenderId(String gender) {
        if (gender == null) {
            return null;
        }
        for (GenderTypeDao genderTypeDao: categories.getGender()) {
            if (genderTypeDao.getGender().equals(gender)) {
                return genderTypeDao.getId();
            }
        }
        throw new RuntimeException("no such category: " + gender);
    }

    public Short getAgeId(String age) {
        if (age == null) {
            return null;
        }
        for (AgeTypeDao ageTypeDao: categories.getAge()) {
            if (ageTypeDao.getAge().equals(age)) {
                return ageTypeDao.getId();
            }
        }
        throw new RuntimeException("no such category: " + age);
    }
}
