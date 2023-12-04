package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController("/")
public class Controller {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("categorias")
    public ResponseEntity<List<CategoriaResponse>> getCategorias(){
        List<CategoriaResponse> categoriaResponseList= categoriaService.getCategorias();
        if(categoriaResponseList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoriaResponseList);
    }
}
