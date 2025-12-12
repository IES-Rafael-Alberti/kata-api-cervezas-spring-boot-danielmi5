package com.example.cervezas.service;

import com.example.cervezas.entity.Brewery;
import com.example.cervezas.exception.EntidadNoEncontradaException;
import com.example.cervezas.repository.BreweryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;

    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    public List<Brewery> obtenerTodas() {
        return breweryRepository.findAll();
    }

    public Brewery obtenerPorId(Integer id) {
        return breweryRepository.findById(id).orElseThrow(() -> new EntidadNoEncontradaException("Brewery with id %d was not found".formatted(id)));
    }
}
