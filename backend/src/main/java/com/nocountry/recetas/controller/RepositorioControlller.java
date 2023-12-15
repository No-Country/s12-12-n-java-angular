package com.nocountry.recetas.controller;

import com.nocountry.recetas.domain.request.RepositorioRequest;
import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.service.RepositoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




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

    @PostMapping(value = "/create-repositorio")
    public ResponseEntity<RepositorioResponse> createRepositorio(@RequestBody RepositorioRequest repositorioRequest) {
        try {
            RepositorioResponse repositorioResponse = repositoryService.createRepositorio(repositorioRequest);

            return ResponseEntity.ok().body(repositorioResponse);


        } catch(Exception e){
                throw new RuntimeException(e);
                //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el repositorio.");
        }
    }
    

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRepositorio(@Valid @RequestParam Long id){
        repositoryService.deleteRepositorio(id);
        return ResponseEntity.noContent().build();
    }
    


    
    
    
}
