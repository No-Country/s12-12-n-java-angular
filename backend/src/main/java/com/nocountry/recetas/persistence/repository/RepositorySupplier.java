package com.nocountry.recetas.persistence.repository;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import org.springframework.stereotype.Component;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.entities.usr.Usr;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.RepositorioResponse;

import lombok.RequiredArgsConstructor;

@Component
public class RepositorySupplier implements Supplier<Optional<List<RepositorioResponse>>> {       

    @Autowired
    private  RepositoryMapper repositoryMapper;

    @Override
    public Optional<List<RepositorioResponse>> get() {
        List<Repositorio> repositorys = repositoryMapper.getRepositorysMapper();
    
        if (repositorys != null && !repositorys.isEmpty()) {
            repositorys.forEach(repositorio -> {
                System.out.println("ID: " + repositorio.getId());
                System.out.println("Receta: " +  repositorio.getReceta().getId());
               System.out.println("USUARIO: " + repositorio.getUsuario().getId());
            });
    
            List<RepositorioResponse> repositoryResponses = repositorys.stream()
                    .map(repositorio -> RepositorioResponse.builder()
                            .id(repositorio.getId())
                           .usuario(repositorio.getUsuario())
                            .receta(repositorio.getReceta())
                            .build())
                    .collect(Collectors.toList());
    
            return Optional.of(repositoryResponses);
        }
        return Optional.empty();
    }
    
    

// public List<RepositorioResponse> getRepositories() {
    //     return repositoryMapper.getRepositorysMapper();
    // }
 }