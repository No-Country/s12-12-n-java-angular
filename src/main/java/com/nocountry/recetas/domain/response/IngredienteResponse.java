package com.nocountry.recetas.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IngredienteResponse {
    private String nombre;
    private double cantidad;
    private String tipo_medida;
}
