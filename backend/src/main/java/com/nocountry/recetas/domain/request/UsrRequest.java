package com.nocountry.recetas.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 8, min = 4)
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
