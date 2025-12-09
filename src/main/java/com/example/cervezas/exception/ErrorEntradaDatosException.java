package com.example.cervezas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorEntradaDatosException extends RuntimeException {
    public ErrorEntradaDatosException(String mensaje) {
        super(mensaje);
    }
}
