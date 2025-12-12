package com.example.cervezas.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StyleDTO {
    private Integer id;
    private Integer categoryId;
    private String styleName;
    private LocalDateTime lastMod;
}
