package com.nocountry.recetas.controller;


import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.request.categorias.HistorialRequest;
import com.nocountry.recetas.domain.response.HistorialResponse;
import com.nocountry.recetas.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping("/get-historial")
    public ResponseEntity<List<HistorialResponse>> getHistorial(){
        return ResponseEntity.ok().body(historialService.getHistorial());

    }
    @PostMapping("/create-historial")
    public ResponseEntity<String> createHistorial(@Valid @RequestBody HistorialRequest historialRequest){
        HistorialResponse historialResponse= historialService.createHistorial(
                Historial
                        .builder()
                        //.receta(historialRequest.getReceta())
                        .build()
        );
        if(historialResponse.getReceta()==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(historialResponse.getReceta().getNombre());
    }

    @DeleteMapping("/delete-historial")
    public ResponseEntity<?> deleteHistorial(@Valid @RequestParam Long id){
        historialService.deleteHistorial(id);
        return ResponseEntity.noContent().build();
    }


}
