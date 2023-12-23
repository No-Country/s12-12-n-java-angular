package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.request.ingrediente.IngredienteRequest;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.domain.response.Response;
import com.nocountry.recetas.service.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService  ingredienteService;

    @GetMapping("/get-ingredientes")
    private ResponseEntity<IngredienteResponse> getIngredientes(@Valid @RequestParam Long id){
        Optional<IngredienteResponse> ingredienteResponse= ingredienteService.getIngredienteService(id);

        return ingredienteResponse.map(response -> ResponseEntity.ok().body(response)).orElseGet(() -> ResponseEntity.noContent().build());

    }

    @PostMapping("/create-ingrediente")
    private ResponseEntity<String> createIngrediente(@Valid @RequestBody IngredienteRequest ingredienteRequest) {

        if (ingredienteService.createIngrediente(ingredienteRequest))
            return ResponseEntity.ok().body("Ingrediente agregado exitosamente");

        return ResponseEntity.internalServerError().body("No se pudo agregar ingrediente");

    }

    @DeleteMapping("/delete-ingrediente")
    private ResponseEntity<String> deleteIngrediente(@Valid @RequestParam Long id){
        if(ingredienteService.deleteIngrediente(id))
            return ResponseEntity.ok().body("Ingrediente eliminado exitosamente");
        return ResponseEntity.internalServerError().body("No se pudo eliminar ingrediente");
    }
}
