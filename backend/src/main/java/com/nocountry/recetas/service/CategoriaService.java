package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.request.categorias.CategoriasRequest;
import com.nocountry.recetas.domain.response.CategoriaResponse;
import com.nocountry.recetas.infra.exeption.ErrorAdvice;
import com.nocountry.recetas.persistence.categoria.CreateCategoriaSupplier;
import com.nocountry.recetas.persistence.categoria.DeleteCategoriaSupplier;
import com.nocountry.recetas.persistence.categoria.GetCategoriaSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CategoriaService {

    @Autowired
    private GetCategoriaSupplier getCategoriaSupplier;

    @Autowired
    private CreateCategoriaSupplier createCategoriaSupplier;

    @Autowired
    private DeleteCategoriaSupplier deleteCategoriaSupplier;

    public List<CategoriaResponse> getCategorias(){
        Optional<List<CategoriaResponse>> categoriaResponses= getCategoriaSupplier.get();
        if(categoriaResponses.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::");
            ErrorAdvice errorAdvice= ErrorAdvice
                    .builder()
                    .message(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::")
                    .action("ERROR AL EJECUTAR CONSULTA")
                    .build();
            throw new RuntimeException(errorAdvice.getMessage());
        }
        return categoriaResponses.get();
    }

    public CategoriaResponse createCategoria(Categoria categoria){
        Optional<CategoriaResponse> categoriaResponse = createCategoriaSupplier.apply(categoria);
        if(categoriaResponse.isEmpty()){
            log.error(":::::::NO EXISTEN DATOS EN CATEGORIAS:::::::");
            ErrorAdvice errorAdvice= ErrorAdvice
                    .builder()
                    .message(":::::::NO SE HA CREADO LA CATEGORIA:::::::")
                    .action("ERROR EJECUTANDO CON" + categoria.getNombre())
                    .build();
            throw new RuntimeException(errorAdvice.getMessage());
        }
        return categoriaResponse.get();
    }

    public void deleteCategoria(Long id){
        try{
            deleteCategoriaSupplier.apply(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
