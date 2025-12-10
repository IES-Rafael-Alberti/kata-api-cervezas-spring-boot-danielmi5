package com.example.cervezas.exception;
import com.example.cervezas.dto.ApiErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadNoEncontradaException.class)
    public ResponseEntity<ApiErrorDTO> handleNotFound(EntidadNoEncontradaException ex, WebRequest request) {
        ApiErrorDTO body = new ApiErrorDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not found", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ErrorEntradaDatosException.class)
    public ResponseEntity<ApiErrorDTO> handleBadRequest(ErrorEntradaDatosException ex, WebRequest request) {
        ApiErrorDTO body = new ApiErrorDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad request", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleOther(Exception ex, WebRequest request) {
        ApiErrorDTO body = new ApiErrorDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
