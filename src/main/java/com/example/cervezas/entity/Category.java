package com.example.cervezas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String catName;

    private LocalDateTime lastMod;
    
    @OneToMany(mappedBy = "category")
    private List<Style> styles;
    
    @OneToMany(mappedBy = "category")
    private List<Beer> beers;
}
