package com.nocountry.recetas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.infra.exeption.ErrorAdvice;
import com.nocountry.recetas.persistence.categoria.CategoriaSupplier;
import com.nocountry.recetas.persistence.repository.CreateRepositorySupplier;
import com.nocountry.recetas.persistence.repository.DeleteRepositorySupplier;
import com.nocountry.recetas.persistence.repository.ListRepositorySupplier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
// @RequiredArgsConstructor
public class RepositoryService {

@Autowired
    private ListRepositorySupplier repositorySupplier;

    @Autowired
    private CreateRepositorySupplier createRepositorySupplier;

    @Autowired
    private DeleteRepositorySupplier deleteRepositorySupplier;

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



    
    public RepositorioResponse createRepositorio(Repositorio repositorio){
        Optional<RepositorioResponse> repositorioResponse = createRepositorySupplier.apply(repositorio);
        if(repositorioResponse.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN REPOSITORIOS:::::::");
            ErrorAdvice errorAdvice= ErrorAdvice
                    .builder()
                    .message(":::::::NO SE HA CREADO EL REPOSITORIO:::::::")
                    .build();
            throw new RuntimeException(errorAdvice.getMessage());
        }
        return repositorioResponse.get();
    }


    
    public void deleteRepositorio(Long id){
        try{
        deleteRepositorySupplier.apply(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    
}