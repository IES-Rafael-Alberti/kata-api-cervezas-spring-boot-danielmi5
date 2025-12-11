package com.example.cervezas.service;

import com.example.cervezas.dto.BeerDTO;
import com.example.cervezas.entity.Beer;
import com.example.cervezas.entity.Brewery;
import com.example.cervezas.entity.Category;
import com.example.cervezas.entity.Style;
import com.example.cervezas.exception.EntidadNoEncontradaException;
import com.example.cervezas.exception.ErrorEntradaDatosException;
import com.example.cervezas.repository.BeerRepository;
import com.example.cervezas.repository.BreweryRepository;
import com.example.cervezas.repository.CategoryRepository;
import com.example.cervezas.repository.StyleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BreweryRepository breweryRepository;
    private final CategoryRepository categoryRepository;
    private final StyleRepository styleRepository;
    private final com.example.cervezas.mapper.BeerMapper beerMapper;

    public BeerService(BeerRepository beerRepository, BreweryRepository breweryRepository, CategoryRepository categoryRepository, StyleRepository styleRepository, com.example.cervezas.mapper.BeerMapper beerMapper) {
        this.beerRepository = beerRepository;
        this.breweryRepository = breweryRepository;
        this.categoryRepository = categoryRepository;
        this.styleRepository = styleRepository;
        this.beerMapper = beerMapper;
    }

    public List<Beer> obtenerTodos() {
        return beerRepository.findAll();
    }

    public Beer obtenerPorId(Integer id) {
        return beerRepository.findById(id).orElseThrow(() -> new EntidadNoEncontradaException("Beer with id %d was not found".formatted(id)));
    }

    @Transactional
    public Beer crear(BeerDTO dto) {
        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ErrorEntradaDatosException("The beer name is required.");
        }
        Beer cerveza = beerMapper.dtoAEntidad(dto);
        if (dto.getBreweryId() != null && !breweryRepository.existsById(dto.getBreweryId())) {
            throw new EntidadNoEncontradaException("Brewery with id %d was not found".formatted(dto.getBreweryId()));
        }
        if (dto.getCategoryId() != null && !categoryRepository.existsById(dto.getCategoryId())) {
            throw new EntidadNoEncontradaException("Category with id %d was not found".formatted(dto.getCategoryId()));
        }
        if (dto.getStyleId() != null && !styleRepository.existsById(dto.getStyleId())) {
            throw new EntidadNoEncontradaException("Style with id %d was not found".formatted(dto.getStyleId()));
        }

        if (cerveza.getLastMod() == null) {
            cerveza.setLastMod(LocalDateTime.now());
        }

        return beerRepository.save(cerveza);
    }

    @Transactional
    public Beer actualizar(Integer id, BeerDTO dto) {
        Beer cervezaYaExiste = obtenerPorId(id);
        
        if (dto.getBreweryId() != null) {
            if (!breweryRepository.existsById(dto.getBreweryId())) {
                throw new EntidadNoEncontradaException("Brewery with id %d was not found".formatted(dto.getBreweryId()));
            }
            cervezaYaExiste.setBrewery(Brewery.builder().id(dto.getBreweryId()).build());
        }
        if (dto.getName() != null) cervezaYaExiste.setName(dto.getName());
        if (dto.getCategoryId() != null) {
            if (!categoryRepository.existsById(dto.getCategoryId())) {
                throw new EntidadNoEncontradaException("Category with id %d was not found".formatted(dto.getCategoryId()));
            }
            cervezaYaExiste.setCategory(Category.builder().id(dto.getCategoryId()).build());
        }
        if (dto.getStyleId() != null) {
            if (!styleRepository.existsById(dto.getStyleId())) {
                throw new EntidadNoEncontradaException("Style with id %d was not found".formatted(dto.getStyleId()));
            }
            cervezaYaExiste.setStyle(Style.builder().id(dto.getStyleId()).build());
        }
        if (dto.getAbv() != null) cervezaYaExiste.setAbv(dto.getAbv());
        if (dto.getIbu() != null) cervezaYaExiste.setIbu(dto.getIbu());
        if (dto.getSrm() != null) cervezaYaExiste.setSrm(dto.getSrm());
        if (dto.getUpc() != null) cervezaYaExiste.setUpc(dto.getUpc());
        if (dto.getFilepath() != null) cervezaYaExiste.setFilepath(dto.getFilepath());
        if (dto.getDescript() != null) cervezaYaExiste.setDescript(dto.getDescript());
        if (dto.getAddUser() != null) cervezaYaExiste.setAddUser(dto.getAddUser());
        if (dto.getLastMod() != null) {
            cervezaYaExiste.setLastMod(dto.getLastMod());
        } else {
            cervezaYaExiste.setLastMod(LocalDateTime.now());
        }

        return beerRepository.save(cervezaYaExiste);
    }

    public void eliminar(Integer id) {
        Beer cervezaYaExiste = obtenerPorId(id);
        beerRepository.delete(cervezaYaExiste);
    }
}
