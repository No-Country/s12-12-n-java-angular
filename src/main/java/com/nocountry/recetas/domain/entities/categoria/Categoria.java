package com.nocountry.recetas.domain.entities.categoria;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categoria")
@Entity(name = "Categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
}
