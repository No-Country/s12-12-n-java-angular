package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.response.RecetaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class RecetaSupplier implements Supplier<Optional<List<RecetaResponse>>> {
    @Autowired
    private RecetaMapper recetaMapper;

    @Override
    public  Optional<List<RecetaResponse>> get(){
        List<Receta> recetas = recetaMapper.getRecetasMapper();
        if(!CollectionUtils.isEmpty(recetas)){
            List<RecetaResponse> recetaResponses = recetas.stream()
                    .map(receta -> RecetaResponse.builder()
                            .nombre(receta.getNombre())
                            .procedimientos(receta.getProcedimientos())
                            .likes(receta.getLikes())
                            .build())
                    .toList();
            return  Optional.of(recetaResponses);
        }
        return  Optional.empty();
    }

}
