package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.persistence.categoria.CategoriaSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CategoriaService {

    @Autowired
    private CategoriaSupplier categoriaSupplier;

    public List<CategoriaResponse> getCategorias(){
        Optional<List<CategoriaResponse>> categoriaResponses= categoriaSupplier.get();
        if(categoriaResponses.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::");
            throw new RuntimeException(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::");
        }
        return categoriaResponses.get();
    }
}
