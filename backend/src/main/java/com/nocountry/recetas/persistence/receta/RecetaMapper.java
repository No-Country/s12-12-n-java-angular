package com.nocountry.recetas.persistence.receta;

import com.nocountry.recetas.domain.entities.receta.Receta;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecetaMapper {
    @Select("SELECT * FROM recetas")
    @Options(timeout = 20)
    List<Receta> getRecetasMapper();
}
