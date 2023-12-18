package com.nocountry.recetas.persistence.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;
import com.nocountry.recetas.domain.request.RepositorioRequest;
import com.nocountry.recetas.persistence.receta.RecetaMapper;
import com.nocountry.recetas.persistence.usr.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.response.RepositorioResponse;

@Component
public class CreateRepositorySupplier implements Function<RepositorioRequest, Optional<RepositorioResponse>> {

    @Autowired
    private RepositoryMapper repositoryMapper;

    @Autowired
    private RecetaMapper recetaMapper;

    @Autowired
    private UsrMapper usrMapper;

    @Override
    public Optional<RepositorioResponse> apply(RepositorioRequest repositorioRequest) {
        Map<String, Object> params= new HashMap<>();

        params.put("usuario",repositorioRequest.getUsuario());
        params.put("receta", repositorioRequest.getReceta());
        
        

        repositoryMapper.createRepositorio(params);

        BigInteger repositorioIdBigInteger = (BigInteger) params.get("id");
        Long repositorioId = repositorioIdBigInteger.longValue();
        
        Receta receta=  recetaMapper.getRecetaById(repositorioRequest.getReceta());
        Usr usr= usrMapper.findByIdUsr(repositorioRequest.getUsuario());
        
        


        return Optional.of(RepositorioResponse
                .builder()
                .id(repositorioId)
                        .receta(receta)
                        .usuario(usr)
                .build()
        );
       
    }

    
}
