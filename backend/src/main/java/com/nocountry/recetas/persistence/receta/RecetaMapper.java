package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.entities.receta.Receta;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecetaMapper {
    @Select("SELECT * FROM recetas")
    @Results({
            @Result(column = "categoria_id", property = "categoria",
                    javaType = Categoria.class, one = @One(select = "com.nocountry.recetas.persistence.categoria.CategoriaMapper.getCategoriaById")),
            @Result(column = "id", property = "ingredientes",
                    javaType = List.class, many = @Many(select = "com.nocountry.recetas.persistence.ingrediente.IngredienteMapper.getIngredientesByRecetaId"))
    })
    List<Receta> getRecetasMapper();
}

