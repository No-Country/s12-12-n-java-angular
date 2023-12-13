package com.nocountry.recetas.persistence.repository;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.RepositorioResponse;

@Component
public class CreateRepositorySupplier implements Function<Repositorio, Optional<RepositorioResponse>> {

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Override
    public Optional<RepositorioResponse> apply(Repositorio repositorio) {
        repositoryMapper.createRepositorio(repositorio);
        return Optional.of(RepositorioResponse.
        builder()
        .usuario(repositorio.getUsuario())
        .receta(repositorio.getReceta())
        .build()
        );
       
    }

    
}
