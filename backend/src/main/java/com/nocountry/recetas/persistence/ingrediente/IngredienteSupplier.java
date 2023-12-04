package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class IngredienteSupplier implements Supplier<Optional<List<IngredienteResponse>>> {
    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public  Optional<List<IngredienteResponse>> get(){
        List<Ingrediente> ingredientes = ingredienteMapper.getIngredientesMapper();
        if(!CollectionUtils.isEmpty(ingredientes)){
            List<IngredienteResponse> ingredienteResponses = ingredientes.stream()
                    .map(ingrediente -> IngredienteResponse.builder()
                            .nombre(ingrediente.getNombre())
                            .cantidad(ingrediente.getCantidad())
                            .tipo_medida(ingrediente.getTipo_medida())
                            .build())
                    .toList();
            return  Optional.of(ingredienteResponses);
        }
        return  Optional.empty();
    }

}
