package com.nocountry.recetas.domain.request;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class RepositorioRequest {


     @Valid
    //  @JsonProperty(value = "usuario_id", access = JsonProperty.Access.READ_ONLY)
    private Usr usuario;

    @Valid
    // @JsonProperty(value="receta_id", access = JsonProperty.Access.READ_ONLY)
    private Receta receta;
}
