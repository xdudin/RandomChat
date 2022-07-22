package com.example.random_chat.controller;

import com.example.random_chat.model.Categories;
import com.example.random_chat.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public String testConnection() {
        return "Connection successful";
    }

    @GetMapping("/categories")
    public Categories getCategories() {
        return categoryService.getCategories();
    }
}
