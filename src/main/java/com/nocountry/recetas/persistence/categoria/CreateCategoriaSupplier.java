package com.nocountry.recetas.persistence.categoria;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.request.categorias.CategoriasRequest;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class CreateCategoriaSupplier implements Function<Categoria, Optional<CategoriaResponse>> {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public Optional<CategoriaResponse> apply(Categoria categoria) {
        categoriaMapper.createCategoria(categoria);
        return Optional.of(CategoriaResponse
                .builder()
                .nombre(categoria.getNombre())
                .build());
    }
}
