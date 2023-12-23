package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class GetIngredienteSupplier implements Function<Long,IngredienteResponse> {
    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public IngredienteResponse apply(Long aLong) {
        try{
            Ingrediente ingrediente= ingredienteMapper.getIngredienteById(aLong);
            return IngredienteResponse.builder()
                    .nombre(ingrediente.getNombre())
                    .cantidad(ingrediente.getCantidad())
                    .tipo_medida(ingrediente.getTipo_medida())
                    .build();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
