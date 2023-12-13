package com.nocountry.recetas.persistence.repository;

import java.util.List;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.jpa.repository.Query;

import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.RepositorioResponse;
import com.nocountry.recetas.domain.response.UsrResponse;

@Mapper
public interface RepositoryMapper {

  @Select("SELECT r.id, u.id as usuario_id, u.nombre as usuario_nombre, rec.id as receta_id, rec.nombre as receta_nombre FROM repositorio r " +
          "JOIN usuarios u ON r.usuario_id = u.id " +
          "JOIN recetas rec ON r.receta_id = rec.id")
  @Results( {
          //descomentar cuando importes el metodo get de usuarios del mapper que tiene alejandro
          @Result( column = "usuario_id", property = "usuario", javaType = Usr.class, one = @One(select = "com.nocountry.recetas.persistence.usr.UsrMapper.findByIdUsr")),
          @Result( column = "receta_id", property = "receta", javaType = Receta.class, one = @One(select = "com.nocountry.recetas.persistence.receta.RecetaMapper.findById"))
  })
  List<Repositorio> getRepositorysMapper();

  @Insert("INSERT INTO repositorio (receta_id, usuario_id) VALUES (#{receta.id}, #{usuario.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createRepositorio(Repositorio repositorio);


    @Delete("DELETE FROM repositorio WHERE id = #{id}")
    void deleteRepositorioById(@Param("id") Long id);

//     INSERT INTO `recetas_db`.`repositorio` (`receta_id`, `usuario_id`) VALUES ('4', '1');
}
// @Select("SELECT r.id as id, u.id as iduser, u.nombre as usuario, rec.nombre
// as receta, rec.id as idreceta " +
// "FROM repositorio r " +
// "JOIN usuarios u ON r.usuario_id = u.id " +
// "JOIN recetas rec ON r.receta_id = rec.id")

