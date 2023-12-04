package com.nocountry.recetas.persistence.repository;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.nocountry.recetas.domain.entities.repositorio.Repositorio;

@Mapper
public interface RepositoryMapper {
 @Select("SELECT * FROM repositorio")
    @Options(timeout = 10)
    List<Repositorio> getRepositorysMapper();
         
}
