package com.nocountry.recetas.persistence.historial;

import com.nocountry.recetas.domain.entities.historial.Historial;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HistorialMapper {

    @Insert("INSERT INTO historial (receta) VALUES (#{receta})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createHistorial(Historial historial);

    @Delete("DELETE FROM historial WHERE id = #{id}")
    void deleteHistorialById(@Param("id") Long id);



    @Select("SELECT * FROM historial")
    @Options(timeout = 10)
    List<Historial> getHistorialMapper();
}
