package com.nocountry.recetas.persistence.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteCategoriaSupplier implements Function<Long, Void> {

    @Autowired
    private CategoriaMapper categoriaMapper;


    @Override
    public Void apply(Long aLong) {
        categoriaMapper.deleteCategoriaById(aLong);
        return null;
    }
}
