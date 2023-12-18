package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.request.ingrediente.IngredienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class CreateIngredienteSupplier implements Function<IngredienteRequest, Boolean> {

    @Autowired
    private IngredienteMapper ingredienteMapper;

    @Override
    public Boolean apply(IngredienteRequest ingredienteRequest) {
        try {
            Map<String,Object> params= new HashMap<>();
            params.put("nombre",ingredienteRequest.getNombre());
            params.put("cantidad",ingredienteRequest.getCantidad());
            params.put("tipoMedida",ingredienteRequest.getTipoMedida());
            params.put("recetaId",ingredienteRequest.getRecetaId());

            ingredienteMapper.createIngrediente(params);

            return true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
