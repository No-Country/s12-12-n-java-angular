package com.nocountry.recetas.persistence.historial;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class DeleteHistorialSupplier  implements Function<Long, Void> {
    @Autowired
    private HistorialMapper historialMapper;


    @Override
    public Void apply(Long aLong) {
        historialMapper.deleteHistorialById(aLong);
        return null;
    }
}