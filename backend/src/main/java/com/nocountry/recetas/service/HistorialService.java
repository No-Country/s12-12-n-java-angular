package com.nocountry.recetas.service;


import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.response.HistorialResponse;
import com.nocountry.recetas.infra.exeption.ErrorAdvice;
import com.nocountry.recetas.persistence.historial.CreateHistorialSupplier;
import com.nocountry.recetas.persistence.historial.DeleteHistorialSupplier;
import com.nocountry.recetas.persistence.historial.GetHistorialSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HistorialService {

    @Autowired
    private GetHistorialSupplier gethistorialSupplier;

    @Autowired
    private CreateHistorialSupplier createHistorialSupplier;

    @Autowired
    private DeleteHistorialSupplier deleteHistorialSupplier;

    @Autowired
    private GetHistorialSupplier getHistorialSupplier;

    public List<HistorialResponse> getHistorial(){
        Optional<List<HistorialResponse>> historialResponses= getHistorialSupplier.get();
        if(historialResponses.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN HISTORIAL:::::::");
            throw new RuntimeException(":::::::NO EXISTEN DATOS EN HISTORIAL:::::::");
        }
        return historialResponses.get();
    }
    public HistorialResponse createHistorial(Historial historial){
        Optional<HistorialResponse> historialResponse = createHistorialSupplier.apply(historial);
        if(historialResponse.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN HISTORIAL:::::::");
            ErrorAdvice errorAdvice= ErrorAdvice
                    .builder()
                    .message(":::::::NO SE HA CREADO EL HISTORIAL:::::::")
                    .build();
            throw new RuntimeException(errorAdvice.getMessage());
        }
        return historialResponse.get();
    }

    public void deleteHistorial(Long id){
        try{
            deleteHistorialSupplier.apply(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }



}
