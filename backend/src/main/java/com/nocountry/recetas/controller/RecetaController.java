package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.request.receta.RecetaRequest;
import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/get-recetas")
    public ResponseEntity<List<RecetaResponse>> getRecetas(){
        List<RecetaResponse> recetaResponses= recetaService.getRecetas();
        if (recetaResponses.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(recetaResponses);
    }

    @GetMapping("/get-receta")
    public ResponseEntity<RecetaResponse> getRecetabyId(@RequestParam Long id){
        RecetaResponse recetaResponse= recetaService.getRecetabyId(id);
        if(recetaResponse == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(recetaResponse);
    }

   @PostMapping("/create-receta")
    public ResponseEntity<RecetaResponse> createReceta(@RequestBody RecetaRequest recetaRequest){
        RecetaResponse recetaResponse= recetaService.createReceta(recetaRequest);
        if(recetaResponse == null)
            return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok().body(recetaResponse);
    }

    @PutMapping("/update-receta")
    public ResponseEntity<RecetaResponse> updateReceta(@RequestParam Long id, @RequestBody RecetaRequest recetaRequest){
        RecetaResponse recetaResponse= recetaService.updateReceta(recetaRequest, id);
        if(recetaResponse == null)
            return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok().body(recetaResponse);
    }

}