package com.nocountry.recetas.persistence.historial;


import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.response.HistorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
@Component

public class HistorialSupplier implements Supplier<Optional<List<HistorialResponse>>>{

    @Autowired
    private HistorialMapper historialMapper;

    @Override
    public Optional<List<HistorialResponse>> get() {
        List<Historial> historial= historialMapper.getHistorialMapper();

        if(!CollectionUtils.isEmpty(historial)){
            List<HistorialResponse> historialResponses = historial.stream()
                    .map(historial -> HistorialResponse.
                            builder().
                            nombre(historial.getid())
                            .build())
                    .toList();
            return Optional.of(historialResponses);
        }
        return Optional.empty();
    }



}
