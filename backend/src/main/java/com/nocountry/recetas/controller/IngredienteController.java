package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.service.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
