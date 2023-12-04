package com.nocountry.recetas.domain.response;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecetaResponse {
    private String nombre;
    private String procedimientos;
    private boolean visible;
    private int likes;

}
