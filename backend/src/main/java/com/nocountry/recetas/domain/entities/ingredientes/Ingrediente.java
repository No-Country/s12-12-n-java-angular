package com.nocountry.recetas.domain.entities.ingredientes;

import com.nocountry.recetas.domain.entities.receta.Receta;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ingredientes")
@Data
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double cantidad;
    private String tipo_medida;

    @ManyToOne
    private Receta recetas;
}

