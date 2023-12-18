package com.nocountry.recetas.domain.request.categorias;

import com.nocountry.recetas.domain.entities.receta.Receta;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HistorialRequest {
    @NotBlank
    private Receta receta;
}
