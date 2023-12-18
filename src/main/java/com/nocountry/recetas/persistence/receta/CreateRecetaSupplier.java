package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.request.receta.RecetaRequest;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.persistence.categoria.CategoriaMapper;
import com.nocountry.recetas.persistence.ingrediente.IngredienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public class CreateRecetaSupplier implements Function<RecetaRequest, Optional<RecetaResponse>> {

    @Autowired
    private RecetaMapper recetaMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public Optional<RecetaResponse> apply(RecetaRequest recetaRequest) {
       try{
           Map<String,Object> params= new HashMap<>();
           params.put("nombre",recetaRequest.getNombre());
           params.put("procedimientos",recetaRequest.getProcedimientos());
           params.put("visible", recetaRequest.isVisible());
           params.put("categoria",recetaRequest.getCategoria());

           recetaMapper.createReceta(params);

           BigInteger idReceta= (BigInteger) params.get("id");
           Integer likes = (Integer) params.get("likes");
           int likesValue = (likes != null) ? likes : 0;

           Categoria categoria= categoriaMapper.getCategoriaById(recetaRequest.getCategoria());
           List<Ingrediente> ingredienteList= ingredienteMapper.getIngredientesByRecetaId(idReceta.longValueExact());


           return Optional.of(RecetaResponse.builder()
                    .id(idReceta.longValueExact())
                    .nombre(recetaRequest.getNombre())
                    .categoria(categoria)
                    .procedimientos(recetaRequest.getProcedimientos())
                    .likes(likesValue)
                    .ingredientes(ingredienteList.stream().map(
                            ingrediente -> IngredienteResponse.builder()
                                    .nombre(ingrediente.getNombre())
                                    .cantidad(ingrediente.getCantidad())
                                    .tipo_medida(ingrediente.getTipo_medida())
                                    .build()
                    ).toList())
                    .visible((Boolean) params.get("visible"))
                   .build());
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }

    }
}
