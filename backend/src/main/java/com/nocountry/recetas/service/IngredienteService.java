package com.nocountry.recetas.service;

import com.nocountry.recetas.domain.response.IngredienteResponse;
import com.nocountry.recetas.persistence.ingrediente.GetIngredienteSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private GetIngredienteSupplier getIngredienteSupplier;

    public Optional<IngredienteResponse> getIngredienteService(Long id) {
        try {
            return Optional.of(getIngredienteSupplier.apply(id));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
