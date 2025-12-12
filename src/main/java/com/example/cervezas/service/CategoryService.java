package com.example.cervezas.service;

import com.example.cervezas.entity.Category;
import com.example.cervezas.exception.EntidadNoEncontradaException;
import com.example.cervezas.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> obtenerTodas() {
        return categoryRepository.findAll();
    }

    public Category obtenerPorId(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntidadNoEncontradaException("Category with id %d was not found".formatted(id)));
    }
}
