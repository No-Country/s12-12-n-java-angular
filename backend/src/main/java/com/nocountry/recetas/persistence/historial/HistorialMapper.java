package com.nocountry.recetas.persistence.historial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.nocountry.recetas.domain.entities.historial.Historial;
import java.util.List;

@Mapper
public interface HistorialMapper {
    @Select("SELECT * FROM historial")
    @Options(timeout = 10)
    List<Historial> getHistorialMapper();
}
