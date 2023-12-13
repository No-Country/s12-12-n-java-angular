package com.nocountry.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.request.RepositorioRequest;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.service.RepositoryService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/repositorios")
public class RepositorioControlller {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/list")
    public ResponseEntity<List<RepositorioResponse>> getRepositorios(){
        List<RepositorioResponse> repositorioResponseList = repositoryService.getRepositorios();
        if(repositorioResponseList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repositorioResponseList);
    }

    // @GetMapping("/list")
    // public ResponseEntity<?> findAll() {
    //     return ResponseEntity.ok(repositoryService.getRepositories());
    // }

    @PostMapping("/create")
    public ResponseEntity<String> createRepositorio(@Valid @RequestBody RepositorioRequest repositorioRequest) {
        try {
            RepositorioResponse repositorioResponse = repositoryService.createRepositorio(
                    Repositorio.builder()
                            .usuario(repositorioRequest.getUsuario())
                            .receta(repositorioRequest.getReceta())
                            .build()
            );
    
            if (repositorioResponse == null || repositorioResponse.getUsuario() == null || repositorioResponse.getReceta() == null) {
                return ResponseEntity.noContent().build();
            }
    
            Long usuarioId = repositorioResponse.getUsuario().getId();
            Long recetaId = repositorioResponse.getReceta().getId();
    
            return ResponseEntity.ok().body("Repositorio creado correctamente. Usuario ID: " + usuarioId + ", Receta ID: " + recetaId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el repositorio.");
        }
    }
    


    
    
    
}
