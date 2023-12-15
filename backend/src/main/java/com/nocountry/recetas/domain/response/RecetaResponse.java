package com.nocountry.recetas.domain.response;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RecetaResponse {
    private Long id;
    private String nombre;
    private String procedimientos;
    private boolean visible;
    private int likes;
    private Categoria categoria;
    private List<IngredienteResponse> ingredientes;

}
