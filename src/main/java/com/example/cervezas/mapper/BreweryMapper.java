package com.example.cervezas.mapper;

import com.example.cervezas.dto.BreweryDTO;
import com.example.cervezas.entity.Brewery;
import org.springframework.stereotype.Component;

@Component
public class BreweryMapper {

    public Brewery dtoAEntidad(BreweryDTO dto) {
        if (dto == null) return null;
        return Brewery.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address1(dto.getAddress1())
                .address2(dto.getAddress2())
                .city(dto.getCity())
                .state(dto.getState())
                .code(dto.getCode())
                .country(dto.getCountry())
                .phone(dto.getPhone())
                .website(dto.getWebsite())
                .filepath(dto.getFilepath())
                .descript(dto.getDescript())
                .addUser(dto.getAddUser())
                .lastMod(dto.getLastMod())
                .build();
    }

    public BreweryDTO entidadADto(Brewery entidad) {
        if (entidad == null) return null;
        return BreweryDTO.builder()
                .id(entidad.getId())
                .name(entidad.getName())
                .address1(entidad.getAddress1())
                .address2(entidad.getAddress2())
                .city(entidad.getCity())
                .state(entidad.getState())
                .code(entidad.getCode())
                .country(entidad.getCountry())
                .phone(entidad.getPhone())
                .website(entidad.getWebsite())
                .filepath(entidad.getFilepath())
                .descript(entidad.getDescript())
                .addUser(entidad.getAddUser())
                .lastMod(entidad.getLastMod())
                .build();
    }
}
