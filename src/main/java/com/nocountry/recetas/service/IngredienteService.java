package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.request.ingrediente.IngredienteRequest;
import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.persistence.ingrediente.CreateIngredienteSupplier;
import com.nocountry.recetas.persistence.ingrediente.DeleteIngredienteSupplier;
import com.nocountry.recetas.persistence.ingrediente.GetIngredienteSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private GetIngredienteSupplier getIngredienteSupplier;

    @Autowired
    private CreateIngredienteSupplier createIngredienteSupplier;

    @Autowired
    private DeleteIngredienteSupplier deleteIngredienteSupplier;

    public Optional<IngredienteResponse> getIngredienteService(Long id) {
        try {
            return Optional.of(getIngredienteSupplier.apply(id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Boolean createIngrediente(IngredienteRequest ingredienteRequest){
        try{
            return createIngredienteSupplier.apply(ingredienteRequest);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Boolean deleteIngrediente(Long id){
        try{
            return deleteIngredienteSupplier.apply(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
