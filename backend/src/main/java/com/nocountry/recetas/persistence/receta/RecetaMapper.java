package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.entities.receta.Receta;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecetaMapper {
    @Select("SELECT r.id, r.id as receta_id, r.nombre, r.procedimientos, r.visible, r.likes, " +
            "r.categoria_id " +
            "FROM recetas r ")
    @Results({
            @Result(column = "categoria_id", property = "categoria",
                    javaType = Categoria.class, one = @One(select = "com.nocountry.recetas.persistence.categoria.CategoriaMapper.getCategoriaById")),
            @Result(column = "receta_id", property = "ingredientes",
                    javaType = List.class, many = @Many(select = "com.nocountry.recetas.persistence.ingrediente.IngredienteMapper.getIngredientesByRecetaId"))
    })
    List<Receta> getRecetasMapper();

    @Select("SELECT r.id, r.id as receta_id, r.nombre, r.procedimientos, r.visible, r.likes, " +
            "r.categoria_id " +
            "FROM recetas r " +
            "WHERE r.id = #{id}")
    @Results({
            @Result(column = "categoria_id", property = "categoria",
                    javaType = Categoria.class, one = @One(select = "com.nocountry.recetas.persistence.categoria.CategoriaMapper.getCategoriaById")),
            @Result(column = "receta_id", property = "ingredientes",
                    javaType = List.class, many = @Many(select = "com.nocountry.recetas.persistence.ingrediente.IngredienteMapper.getIngredientesByRecetaId"))
    })
    Receta getRecetaById(@Param("id") Long id);

    @Insert("INSERT INTO recetas(nombre,procedimientos,visible,categoria_id,likes) " +
            "VALUES (#{nombre}, #{procedimientos}, #{visible}, #{categoria},0)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createReceta(Map<String, Object> params);

    @Update("UPDATE recetas " +
            "SET nombre = #{nombre}, " +
            "procedimientos = #{procedimientos}, " +
            "visible = #{visible}, " +
            "categoria_id = #{categoria} " +
            "WHERE id = #{idReceta}")
    void updateReceta(Map<String, Object> params);
}

