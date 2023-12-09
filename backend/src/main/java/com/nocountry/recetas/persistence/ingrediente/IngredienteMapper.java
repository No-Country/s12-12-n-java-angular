package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IngredienteMapper {
    @Select("SELECT * FROM ingredientes WHERE id = #{id}")
    @Options(timeout = 20)
    Ingrediente getIngredienteById(@Param("id") Long id);

    @Select("SELECT * FROM ingredientes WHERE id = #{id}")
    @Options(timeout = 20)
    List<Ingrediente> getIngredientesById(@Param("id") Long id);

    @Select("SELECT i.* FROM ingredientes i WHERE i.recetas_id = #{recetaId}")
    List<Ingrediente> getIngredientesByRecetaId(@Param("recetaId") Long recetaId);

}
