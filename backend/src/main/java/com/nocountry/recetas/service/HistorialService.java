package com.nocountry.recetas.service;


import com.nocountry.recetas.domain.response.HistorialResponse;
import com.nocountry.recetas.persistence.historial.HistorialSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HistorialService {

    @Autowired
    private HistorialSupplier historialSupplier;

    public List<HistorialResponse> getHistorial(){
        Optional<List<HistorialResponse>> historialResponses= historialSupplier.get();
        if(historialResponses.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN HISTORIAL:::::::");
            throw new RuntimeException(":::::::NO EXISTEN DATOS EN HISTORIAL:::::::");
        }
        return historialResponses.get();
    }

}
