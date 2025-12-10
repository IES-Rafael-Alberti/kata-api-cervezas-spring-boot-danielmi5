package com.example.cervezas.controller;

import com.example.cervezas.dto.BeerDTO;
import com.example.cervezas.entity.Beer;
import com.example.cervezas.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    private final BeerService servicioCervezas;

    public BeerController(BeerService servicioCervezas) {
        this.servicioCervezas = servicioCervezas;
    }

    @GetMapping("/beers")
    public List<Beer> obtenerTodas() {
        return servicioCervezas.obtenerTodos();
    }

    @PostMapping("/beer")
    public ResponseEntity<Beer> crear(@RequestBody BeerDTO dto) {
        Beer creada = servicioCervezas.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping("/beer/{id}")
    public Beer obtenerPorId(@PathVariable Integer id) {
        return servicioCervezas.obtenerPorId(id);
    }

    @DeleteMapping("/beer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        servicioCervezas.eliminar(id);
    }

    @PutMapping("/beer/{id}")
    public Beer actualizar(@PathVariable Integer id, @RequestBody BeerDTO dto) {
        return servicioCervezas.actualizar(id, dto);
    }

    @PatchMapping("/beer/{id}")
    public Beer actualizarParcialmente(@PathVariable Integer id, @RequestBody BeerDTO dto) {
        return servicioCervezas.actualizarParcialmente(id, dto);
    }
}
