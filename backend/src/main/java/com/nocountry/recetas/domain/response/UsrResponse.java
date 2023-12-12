package com.nocountry.recetas.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsrResponse {

    private Long id;
    private String nombre;
    private String email;

}
