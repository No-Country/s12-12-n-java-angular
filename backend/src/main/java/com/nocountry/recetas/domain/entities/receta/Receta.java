package com.nocountry.recetas.domain.entities.receta;

import com.nocountry.recetas.domain.entities.categoria.Categoria;
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

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "recetas", cascade = CascadeType.ALL)
    private List<Ingrediente> ingredientes;

}
