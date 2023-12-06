package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.response.RecetaResponse;
import com.nocountry.recetas.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class Controller {

    @Autowired
    private RecetaService recetaService;
    @GetMapping("recetas")
    public ResponseEntity<List<RecetaResponse>> getRecetas(){
        List<RecetaResponse> recetaResponseList= recetaService.getRecetas();
        if(recetaResponseList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(recetaResponseList);
    }
}
