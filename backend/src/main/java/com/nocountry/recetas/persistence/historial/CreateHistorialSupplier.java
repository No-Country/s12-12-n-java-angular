package com.nocountry.recetas.persistence.historial;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.HistorialResponse;
import com.nocountry.recetas.persistence.categoria.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;
@Component
public class CreateHistorialSupplier implements Function<Historial, Optional<HistorialResponse>> {

    @Autowired
    private HistorialMapper historialMapper;

    @Override
    public Optional<HistorialResponse> apply(Historial historial) {
        historialMapper.createHistorial(historial);
        return Optional.of(HistorialResponse
                .builder()
                .receta(historial.getReceta())
                .build());
    }


}
