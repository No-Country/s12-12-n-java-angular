package com.nocountry.recetas.persistence.categoria;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


@Component
public class CategoriaSupplier implements Supplier<Optional<List<CategoriaResponse>>> {

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public Optional<List<CategoriaResponse>> get() {
        List<Categoria> categorias= categoriaMapper.getCategoriasMapper();

        if(!CollectionUtils.isEmpty(categorias)){
            List<CategoriaResponse> categoriaResponses = categorias.stream()
                    .map(categoria -> CategoriaResponse.
                            builder().
                            nombre(categoria.getNombre())
                            .build())
                    .toList();
            return Optional.of(categoriaResponses);
        }
        return Optional.empty();
    }
}
