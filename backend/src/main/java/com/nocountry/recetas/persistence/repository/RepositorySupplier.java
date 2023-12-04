package com.nocountry.recetas.persistence.repository;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import org.springframework.stereotype.Component;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.domain.response.RepositorioResponse;

@Component
public class RepositorySupplier implements Supplier<Optional<List<RepositorioResponse>>>{       

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Override
    public Optional<List<RepositorioResponse>> get() {
        List<Repositorio> repositorys= repositoryMapper.getRepositorysMapper();

        if(!CollectionUtils.isEmpty(repositorys)){
            List<RepositorioResponse> repositoryResponses = repositorys.stream()
                    .map(repositorio -> RepositorioResponse.
                            builder().
                            receta(repositorio.getReceta())
                            .build())
                    .toList();
            return Optional.of(repositoryResponses);
        }
        return Optional.empty();
    }



    
}
