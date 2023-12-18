package com.nocountry.recetas.persistence.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteIngredienteSupplier implements Function<Long, Boolean> {

    @Autowired
    private IngredienteMapper ingredienteMapper;


    @Override
    public Boolean apply(Long aLong) {
        try {
            ingredienteMapper.deleteIngredienteById(aLong);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
