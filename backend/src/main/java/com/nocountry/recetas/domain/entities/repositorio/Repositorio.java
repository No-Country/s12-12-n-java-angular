package com.nocountry.recetas.domain.entities.repositorio;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "repositorio")
@Entity(name = "repositorio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Repositorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usr usuario;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;
    
}
