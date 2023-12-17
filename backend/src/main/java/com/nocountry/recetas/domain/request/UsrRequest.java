package com.nocountry.recetas.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsrRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
