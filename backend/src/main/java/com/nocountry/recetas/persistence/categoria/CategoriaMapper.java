package com.nocountry.recetas.persistence.categoria;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    @Select("SELECT * FROM categoria")
    @Options(timeout = 10)
    List<Categoria> getCategoriasMapper();

    @Insert("INSERT INTO categoria (nombre) VALUES (#{nombre})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createCategoria(Categoria ctaegoria);

    @Delete("DELETE FROM categoria WHERE id = #{id}")
    void deleteCategoriaById(@Param("id") Long id);

    @Select("SELECT * FROM categoria WHERE id = #{id}")
    @Options(timeout = 20)
    Categoria getCategoriaById(@Param("id") Long id);
}
