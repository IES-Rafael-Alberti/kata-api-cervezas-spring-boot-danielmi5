package com.example.cervezas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "breweries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String code;

    private String country;

    private String phone;

    private String website;

    private String filepath;

    @Lob
    private String descript;

    private Integer addUser;

    private LocalDateTime lastMod;

    @OneToMany(mappedBy = "brewery")
    private List<Beer> beers;
}
