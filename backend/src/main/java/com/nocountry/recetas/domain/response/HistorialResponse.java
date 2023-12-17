package com.nocountry.recetas.domain.response;

import com.nocountry.recetas.domain.entities.receta.Receta;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HistorialResponse {

    private Receta receta;


}
