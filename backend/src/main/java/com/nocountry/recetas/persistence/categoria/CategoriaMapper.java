package com.nocountry.recetas.persistence.categoria;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    @Select("SELECT * FROM categoria")
    @Options(timeout = 10)
    List<Categoria> getCategoriasMapper();
}
