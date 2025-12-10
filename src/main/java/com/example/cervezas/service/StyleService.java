package com.example.cervezas.service;

import com.example.cervezas.entity.Style;
import com.example.cervezas.exception.EntidadNoEncontradaException;
import com.example.cervezas.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService {
    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<Style> obtenerTodos() {
        return styleRepository.findAll();
    }

    public Style obtenerPorId(Integer id) {
        return styleRepository.findById(id).orElseThrow(() -> new EntidadNoEncontradaException("Style with id %d was not found".formatted(id)));
    }
}
