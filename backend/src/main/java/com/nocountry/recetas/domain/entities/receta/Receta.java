package com.nocountry.recetas.domain.entities.receta;

import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "recetas")
@Data
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String procedimientos;
    private boolean visible;
    private int likes;

    /*
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "receta_ingredientes",
            joinColumns = @JoinColumn(name = "receta_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredientes;

     */
}
