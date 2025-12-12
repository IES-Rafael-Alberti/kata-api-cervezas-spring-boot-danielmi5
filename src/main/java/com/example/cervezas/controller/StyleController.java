package com.example.cervezas.controller;

import com.example.cervezas.entity.Style;
import com.example.cervezas.service.StyleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StyleController {

    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping("/styles")
    public List<Style> obtenerTodos() {
        return styleService.obtenerTodos();
    }

    @GetMapping("/style/{id}")
    public Style obtenerPorId(@PathVariable Integer id) {
        return styleService.obtenerPorId(id);
    }
}
