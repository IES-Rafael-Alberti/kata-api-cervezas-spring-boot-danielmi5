package com.example.cervezas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
