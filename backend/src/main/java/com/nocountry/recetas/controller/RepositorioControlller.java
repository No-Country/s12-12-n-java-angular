package com.nocountry.recetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.service.RepositoryService;


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
    
}
