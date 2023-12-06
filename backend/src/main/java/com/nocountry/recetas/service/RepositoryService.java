package com.nocountry.recetas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.persistence.categoria.CategoriaSupplier;
import com.nocountry.recetas.persistence.repository.RepositorySupplier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
// @RequiredArgsConstructor
public class RepositoryService {

@Autowired
    private RepositorySupplier repositorySupplier;

    public List<RepositorioResponse> getRepositorios(){
        Optional<List<RepositorioResponse>> repositorioResponses= repositorySupplier.get();
        if(repositorioResponses.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN REPOSITORIOS:::::::");
            throw new RuntimeException(":::::::NO EXISTEN DATOS EN REPOSITORIOS:::::::");
        }
        return repositorioResponses.get();
    }

    // public List<RepositorioResponse> getRepositories() {
    //     return repositorySupplier.getRepositories();
    // }
    
}