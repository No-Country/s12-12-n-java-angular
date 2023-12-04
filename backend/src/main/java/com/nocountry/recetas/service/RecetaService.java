package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.persistence.receta.RecetaSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecetaService {

    @Autowired
    private RecetaSupplier recetaSupplier;

    public List<RecetaResponse> getRecetas(){
        Optional<List<RecetaResponse>> recetaResponses = recetaSupplier.get();
        if (recetaResponses.isEmpty()){
            //log.error("No existen datos en RECETA");
            throw new RuntimeException("No existen datos en RECETA");
        }
        return recetaResponses.get();
    }

}
