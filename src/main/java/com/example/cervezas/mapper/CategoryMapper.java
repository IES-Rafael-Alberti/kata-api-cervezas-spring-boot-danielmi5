package com.example.cervezas.mapper;

import com.example.cervezas.dto.CategoryDTO;
import com.example.cervezas.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category dtoAEntidad(CategoryDTO dto) {
        if (dto == null) return null;
        return Category.builder()
                .id(dto.getId())
                .catName(dto.getCatName())
                .lastMod(dto.getLastMod())
                .build();
    }

    public CategoryDTO entidadADto(Category entidad) {
        if (entidad == null) return null;
        return CategoryDTO.builder()
                .id(entidad.getId())
                .catName(entidad.getCatName())
                .lastMod(entidad.getLastMod())
                .build();
    }
}
