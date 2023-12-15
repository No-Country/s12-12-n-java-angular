package com.nocountry.recetas.domain.request.ingrediente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class IngredienteRequest {
    private String nombre;
    private Double cantidad;
    private String tipoMedida;
    private Long recetaId;
}
