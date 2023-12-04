package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IngredienteMapper {
    @Select("SELECT * FROM ingredientes")
    @Options(timeout = 20)
    List<Ingrediente> getIngredientesMapper();
}
