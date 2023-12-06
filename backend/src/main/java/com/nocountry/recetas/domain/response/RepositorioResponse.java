package com.nocountry.recetas.domain.response;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;    

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RepositorioResponse {
    private Long id;

    
    private Usuario  usuario;

    private  Receta receta;

 
    
    

    
}

