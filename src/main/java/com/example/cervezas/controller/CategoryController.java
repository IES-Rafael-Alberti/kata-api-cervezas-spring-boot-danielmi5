package com.example.cervezas.controller;

import com.example.cervezas.entity.Category;
import com.example.cervezas.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> obtenerTodas() {
        return categoryService.obtenerTodas();
    }

    @GetMapping("/categorie/{id}")
    public Category obtenerPorId(@PathVariable Integer id) {
        return categoryService.obtenerPorId(id);
    }
}
