package com.nocountry.recetas.domain.entities.receta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nocountry.recetas.domain.entities.categoria.Categoria;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity(name = "Receta")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    //@JsonBackReference
    private Categoria categoria;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Ingrediente> ingredientes;
}
