package com.nocountry.recetas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.persistence.repository.RepositorySupplier;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class RepositoryService {

    @Autowired
    private RepositorySupplier repositorySupplier;
    
    public List<RepositorioResponse> getRepositorios(){
        Optional<List<RepositorioResponse>> repositorioResponses = repositorySupplier.get();

        if(repositorioResponses.isEmpty()){

            log.error(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::");
            throw new RuntimeException(":::::::::::::: NO EXISTEN DATOS EN REPOSITORIO");
        }
        return repositorioResponses.get();

    }
    
}
