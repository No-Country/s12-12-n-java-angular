package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.request.receta.RecetaRequest;
import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.persistence.receta.CreateRecetaSupplier;
import com.nocountry.recetas.persistence.receta.GetRecetaSupplier;
import com.nocountry.recetas.persistence.receta.UpdateRecetaSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class RecetaService {

    @Autowired
    private GetRecetaSupplier getRecetaSupplier;

    @Autowired
    private CreateRecetaSupplier createRecetaSupplier;

    @Autowired
    private UpdateRecetaSupplier updateRecetaSupplier;

    public List<RecetaResponse> getRecetas(){
        Optional<List<RecetaResponse>> recetaResponses = getRecetaSupplier.get();
        if (recetaResponses.isEmpty()){
            //log.error("No existen datos en RECETA");
            throw new RuntimeException("No existen datos en RECETA");
        }
        return recetaResponses.get();
    }

    public RecetaResponse getRecetabyId(Long id) {
        Optional<RecetaResponse> recetaResponse= getRecetaSupplier.get(id);
        if(recetaResponse.isEmpty())
            throw new RuntimeException("No existen datos en RECETA");
        return recetaResponse.get();
    }

    public RecetaResponse createReceta(RecetaRequest recetaRequest) {
        Optional<RecetaResponse> recetaResponse= createRecetaSupplier.apply(recetaRequest);
        if(recetaResponse.isEmpty())
            throw new RuntimeException("No existen datos en RECETA");
        return recetaResponse.get();
    }

    public RecetaResponse updateReceta(RecetaRequest recetaRequest, Long id) {
        Map<String,Object> params= new HashMap<>();
        params.put("idReceta",id);
        params.put("nombre",recetaRequest.getNombre());
        params.put("procedimientos",recetaRequest.getProcedimientos());
        params.put("visible", recetaRequest.isVisible());
        params.put("categoria",recetaRequest.getCategoria());

        Optional<RecetaResponse> recetaResponse= updateRecetaSupplier.apply(params);
        if (recetaResponse.isEmpty())
            throw new RuntimeException("Error al actualizar receta");
        return recetaResponse.get();
    }
}
