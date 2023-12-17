package com.nocountry.recetas.persistence.repository;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteRepositorySupplier implements Function<Long, Void> {

    @Autowired
    private RepositoryMapper repositoryMapper;


    @Override
    public Void apply(Long aLong) {
        repositoryMapper.deleteRepositorioById(aLong);
        return null;
    }
}