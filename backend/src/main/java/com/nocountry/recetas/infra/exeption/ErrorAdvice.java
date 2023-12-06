package com.nocountry.recetas.infra.exeption;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorAdvice {
    private String action;
    private String message;
    private LocalDateTime date = LocalDateTime.now();
    private String messageType;
    private Object detalle;
}
