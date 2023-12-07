package com.nocountry.recetas.persistence.usr;

import com.nocountry.recetas.domain.response.UsrResponse;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsrMapper {

    @Select("SELECT * FROM usuarios")
    List<UsrResponse> findAll();

    @Select("SELECT * FROM usuarios WHERE id = #{id}")
    UsrResponse findById(@Param("id") Long id);

    @Insert("INSERT INTO usuarios(nombre, email, password) VALUES(#{nombre}, #{email}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Map<String, Object> request);

    @Delete("DELETE FROM usuarios WHERE id = #{id}")
    void deleteById(@Param("id") Long id);


}
