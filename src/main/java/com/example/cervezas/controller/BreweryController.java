package com.example.cervezas.controller;

import com.example.cervezas.entity.Brewery;
import com.example.cervezas.service.BreweryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BreweryController {

    private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping("/breweries")
    public List<Brewery> obtenerTodas() {
        return breweryService.obtenerTodas();
    }

    @GetMapping("/brewerie/{id}")
    public Brewery obtenerPorId(@PathVariable Integer id) {
        return breweryService.obtenerPorId(id);
    }
}
