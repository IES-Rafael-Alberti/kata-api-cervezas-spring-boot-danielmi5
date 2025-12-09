package com.example.cervezas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class OperacionFallidaException extends RuntimeException {
    public OperacionFallidaException(String mensaje) {
        super(mensaje);
    }
}
