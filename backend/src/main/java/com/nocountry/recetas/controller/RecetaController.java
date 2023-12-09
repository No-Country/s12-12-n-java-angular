package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping("/get-recetas")
    public ResponseEntity<List<RecetaResponse>> getRecetas(){
        return ResponseEntity.ok().body(recetaService.getRecetas());
    }

}
