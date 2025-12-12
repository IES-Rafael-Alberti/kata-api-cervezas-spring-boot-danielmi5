package com.example.cervezas.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
    private Integer id;
    private Integer breweryId;
    private String name;
    private Integer categoryId;
    private Integer styleId;
    private Float abv;
    private Float ibu;
    private Float srm;
    private Integer upc;
    private String filepath;
    private String descript;
    private Integer addUser;
    private LocalDateTime lastMod;
}
