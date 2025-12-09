package com.example.cervezas.mapper;

import com.example.cervezas.dto.BeerDTO;
import com.example.cervezas.entity.Beer;
import com.example.cervezas.entity.Brewery;
import com.example.cervezas.entity.Category;
import com.example.cervezas.entity.Style;
import org.springframework.stereotype.Component;

@Component
public class BeerMapper {

    public Beer dtoAEntidad(BeerDTO dto) {
        if (dto == null) return null;
        Brewery cervecera = dto.getBreweryId() != null ? Brewery.builder().id(dto.getBreweryId()).build() : null;
        Category categoria = dto.getCategoryId() != null ? Category.builder().id(dto.getCategoryId()).build() : null;
        Style estilo = dto.getStyleId() != null ? Style.builder().id(dto.getStyleId()).build() : null;
        return Beer.builder()
                .id(dto.getId())
                .brewery(cervecera)
                .name(dto.getName())
                .category(categoria)
                .style(estilo)
                .abv(dto.getAbv())
                .ibu(dto.getIbu())
                .srm(dto.getSrm())
                .upc(dto.getUpc())
                .filepath(dto.getFilepath())
                .descript(dto.getDescript())
                .addUser(dto.getAddUser())
                .lastMod(dto.getLastMod())
                .build();
    }

    public BeerDTO entidadADto(Beer entidad) {
        if (entidad == null) return null;
        Integer breweryId = entidad.getBrewery() != null ? entidad.getBrewery().getId() : null;
        Integer categoryId = entidad.getCategory() != null ? entidad.getCategory().getId() : null;
        Integer styleId = entidad.getStyle() != null ? entidad.getStyle().getId() : null;
        return BeerDTO.builder()
                .id(entidad.getId())
                .breweryId(breweryId)
                .name(entidad.getName())
                .categoryId(categoryId)
                .styleId(styleId)
                .abv(entidad.getAbv())
                .ibu(entidad.getIbu())
                .srm(entidad.getSrm())
                .upc(entidad.getUpc())
                .filepath(entidad.getFilepath())
                .descript(entidad.getDescript())
                .addUser(entidad.getAddUser())
                .lastMod(entidad.getLastMod())
                .build();
    }
}
