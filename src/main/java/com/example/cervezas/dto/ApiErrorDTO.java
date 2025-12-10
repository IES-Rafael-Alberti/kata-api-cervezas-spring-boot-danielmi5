package com.example.cervezas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDTO {
    private LocalDateTime timestamp;
    private int estado;
    private String error;
    private String mensaje;
}
