package com.nocountry.recetas.domain.entities.receta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nocountry.recetas.domain.entities.ingredientes.Ingrediente;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;
import com.nocountry.recetas.domain.entities.usr.Usuario;

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

        @ManyToMany(mappedBy = "recetas")
        private List<Usuario> usuarios;

        @OneToMany(mappedBy = "receta")
         @JsonBackReference
        private List<Repositorio> repositorios;
        /*
         * @ManyToOne
         * 
         * @JoinColumn(name = "categoria_id")
         * private Categoria categoria;
         * 
         * @ManyToMany
         * 
         * @JoinTable(
         * name = "receta_ingredientes",
         * joinColumns = @JoinColumn(name = "receta_id"),
         * inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
         * )
         * private List<Ingrediente> ingredientes;
         * 
         */
}
