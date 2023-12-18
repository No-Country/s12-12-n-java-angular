package com.nocountry.recetas.persistence.ingrediente;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface IngredienteMapper {
    @Select("SELECT * FROM ingredientes WHERE id = #{id}")
    @Options(timeout = 20)
    Ingrediente getIngredienteById(@Param("id") Long id);

    @Select("SELECT * FROM ingredientes WHERE id = #{id}")
    @Options(timeout = 20)
    List<Ingrediente> getIngredientesById(@Param("id") Long id);

    @Select("SELECT i.* FROM ingredientes i WHERE i.recetas_id = #{recetaId}")
    @Options(timeout = 20)
    List<Ingrediente> getIngredientesByRecetaId(@Param("recetaId") Long recetaId);

    @Insert("INSERT INTO ingredientes(nombre,cantidad,tipo_medida,recetas_id) " +
            "VALUES (#{nombre}, #{cantidad}, #{tipoMedida}, #{recetaId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createIngrediente(Map<String,Object> params);

    @Delete("DELETE FROM ingredientes WHERE id = #{id}")
    void deleteIngredienteById(@Param("id") Long id);
}
