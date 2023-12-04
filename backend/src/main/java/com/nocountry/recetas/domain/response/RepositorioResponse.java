package com.nocountry.recetas.domain.response;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RepositorioResponse {
    private Usr  usuario;
    private Receta receta;
    
}
