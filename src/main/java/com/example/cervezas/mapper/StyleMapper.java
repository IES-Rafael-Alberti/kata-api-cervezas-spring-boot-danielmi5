package com.example.cervezas.mapper;

import com.example.cervezas.dto.StyleDTO;
import com.example.cervezas.entity.Category;
import com.example.cervezas.entity.Style;
import org.springframework.stereotype.Component;

@Component
public class StyleMapper {

    public Style dtoAEntidad(StyleDTO dto) {
        if (dto == null) return null;
        Category categoria = dto.getCategoryId() != null ? Category.builder().id(dto.getCategoryId()).build() : null;
        return Style.builder()
                .id(dto.getId())
                .category(categoria)
                .styleName(dto.getStyleName())
                .lastMod(dto.getLastMod())
                .build();
    }

    public StyleDTO entidadADto(Style entidad) {
        if (entidad == null) return null;
        Integer categoriaId = entidad.getCategory() != null ? entidad.getCategory().getId() : null;
        return StyleDTO.builder()
                .id(entidad.getId())
                .categoryId(categoriaId)
                .styleName(entidad.getStyleName())
                .lastMod(entidad.getLastMod())
                .build();
    }
}
