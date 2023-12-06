package com.nocountry.recetas.persistence.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.jpa.repository.Query;

import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.RepositorioResponse;

@Mapper
public interface RepositoryMapper {

  @Select("SELECT r.id, u.*, rec.* FROM repositorio r " +
  "JOIN usuarios u ON r.usuario_id = u.id " +
  "JOIN recetas rec ON r.receta_id = rec.id")
    @Results( {
      @Result( column = "usuario_id", property = "usuario.id", jdbcType = JdbcType.LONGVARBINARY),
      @Result( column = "receta_id", property = "receta.id", jdbcType = JdbcType.LONGVARBINARY)
    })
    @Options(timeout = 10)
    List<Repositorio> getRepositorysMapper();

}
// @Select("SELECT r.id as id, u.id as iduser, u.nombre as usuario, rec.nombre
// as receta, rec.id as idreceta " +
// "FROM repositorio r " +
// "JOIN usuarios u ON r.usuario_id = u.id " +
// "JOIN recetas rec ON r.receta_id = rec.id")