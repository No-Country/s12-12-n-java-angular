package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.persistence.categoria.CategoriaMapper;
import com.nocountry.recetas.persistence.ingrediente.IngredienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public class UpdateRecetaSupplier implements Function<Map<String,Object>, Optional<RecetaResponse>> {

    @Autowired
    private RecetaMapper recetaMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public Optional<RecetaResponse> apply(Map<String,Object> params) {
        try{
            recetaMapper.updateReceta(params);

            Integer likes = (Integer) params.get("likes");
            int likesValue = (likes != null) ? likes : 0;


            Categoria categoria= categoriaMapper.getCategoriaById((Long) params.get("categoria"));
            List<Ingrediente> ingredienteList= ingredienteMapper.getIngredientesByRecetaId((Long) params.get("idReceta"));


            return Optional.of(RecetaResponse.builder()
                    .id((Long) params.get("idReceta"))
                    .nombre((String) params.get("nombre"))
                    .categoria(categoria)
                    .procedimientos((String) params.get("procedimientos"))
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
            throw new RuntimeException(e);
        }
    }

}
