package com.nocountry.recetas.persistence.historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteHistorialSupplier  implements Function<Long, Void> {
    @Autowired
    private HistorialMapper historialMapper;


    @Override
    public Void apply(Long aLong) {
        historialMapper.deleteHistorialById(aLong);
        return null;
    }
}