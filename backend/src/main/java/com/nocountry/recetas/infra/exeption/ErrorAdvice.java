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
    private String message;
}
