package com.example.cervezas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "beers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;
    
    private Float abv;
    
    private Float ibu;
    
    private Float srm;
    
    private Integer upc;
    
    private String filepath;
    
    @Lob
    private String descript;
    
    private Integer addUser;

    private LocalDateTime lastMod;
}
