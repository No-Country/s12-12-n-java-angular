package com.nocountry.recetas.domain.entities.usr;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nocountry.recetas.domain.entities.historial.Historial;
import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.repositorio.Repositorio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usuario")
     @JsonBackReference
    private List<Repositorio> repositorios;

    @ManyToMany
    @JoinTable(name = "repositorio", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "receta_id"))
    private List<Receta> recetas;

    // private Historial historial;
}
