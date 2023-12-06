package com.nocountry.recetas.infra.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExeption {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorAdvice exception(Exception ex) {
        log.error(":::: Error -  : {} ::::", ex.getMessage());
        return ErrorAdvice.builder().message(ex.getMessage()).build();
    }
}
