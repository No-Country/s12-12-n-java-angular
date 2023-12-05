package com.nocountry.recetas.persistence.historial;
import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.response.HistorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
@Component

public class HistorialSupplier implements Supplier<Optional<List<CategoriaResponse>>>{

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public Optional<List<HistorialResponse>> get() {
        List<Historial> historial= HistorialMapper.getHistorialMapper();

        if(!CollectionUtils.isEmpty(historial)){
            List<HistorialResponse> historialResponses = historial.stream()
                    .map(historial -> HistorialResponse.
                            builder().
                            nombre(historial.getNombre())
                            .build())
                    .toList();
            return Optional.of(historialResponses);
        }
        return Optional.empty();
    }



}
