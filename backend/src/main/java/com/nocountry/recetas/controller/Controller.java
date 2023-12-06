package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.request.categorias.CategoriasRequest;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/categorias")
public class Controller {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/get-categorias")
    public ResponseEntity<List<CategoriaResponse>> getCategorias(){
        List<CategoriaResponse> categoriaResponseList= categoriaService.getCategorias();
        if(categoriaResponseList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoriaResponseList);
    }

    @PostMapping("/create-categoria")
    public ResponseEntity<String> createCategorias(@Valid @RequestBody CategoriasRequest categoriasRequest){
        CategoriaResponse categoriaResponse= categoriaService.createCategoria(
                Categoria
                        .builder()
                        .nombre(categoriasRequest.getNombre())
                        .build()
        );
        if(categoriaResponse.getNombre().isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(categoriaResponse.getNombre());
    }

    @DeleteMapping("/delete-categoria")
    public ResponseEntity<?> deleteCategorias(@Valid @RequestParam Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}