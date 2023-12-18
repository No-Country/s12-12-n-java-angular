package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.domain.response.RecetaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class GetRecetaSupplier implements Supplier<Optional<List<RecetaResponse>>> {
    @Autowired
    private RecetaMapper recetaMapper;

    @Override
    public Optional<List<RecetaResponse>> get() {
        List<Receta> recetas = recetaMapper.getRecetasMapper();
        if (!CollectionUtils.isEmpty(recetas)) {
            List<RecetaResponse> recetaResponses = recetas.stream()
                    .map(receta -> RecetaResponse.builder()
                            .id(receta.getId())
                            .nombre(receta.getNombre())
                            .procedimientos(receta.getProcedimientos())
                            .likes(receta.getLikes())
                            .categoria(receta.getCategoria())
                            .ingredientes(receta.getIngredientes().stream().map(
                                    ingrediente -> IngredienteResponse.builder()
                                            .nombre(ingrediente.getNombre())
                                            .cantidad(ingrediente.getCantidad())
                                            .tipo_medida(ingrediente.getTipo_medida())
                                            .build()
                            ).toList())
                            .build())
                    .toList();
            return Optional.of(recetaResponses);
        }
        return Optional.empty();
    }

    public Optional<RecetaResponse> get(Long id) {
        Receta receta = recetaMapper.getRecetaById(id);
        if (!(receta == null)) {
            return Optional.of(RecetaResponse.builder()
                            .id(receta.getId())
                            .nombre(receta.getNombre())
                            .procedimientos(receta.getProcedimientos())
                            .likes(receta.getLikes())
                            .categoria(receta.getCategoria())
                            .ingredientes(receta.getIngredientes().stream().map(
                                    ingrediente -> IngredienteResponse.builder()
                                            .nombre(ingrediente.getNombre())
                                            .cantidad(ingrediente.getCantidad())
                                            .tipo_medida(ingrediente.getTipo_medida())
                                            .build()
                            ).toList())
                    .build());
        }
        return Optional.empty();
    }

}
