package com.nocountry.recetas.domain.request.receta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RecetaRequest {
    private String nombre;
    private String procedimientos;
    private boolean visible;
    private Long categoria;
}
