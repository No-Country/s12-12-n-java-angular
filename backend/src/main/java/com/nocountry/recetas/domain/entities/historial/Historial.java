package com.nocountry.recetas.domain.entities.historial;

import com.nocountry.recetas.domain.entities.receta.Receta;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "historial")
@Entity(name = "Historial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Historial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @Column(name = "receta")
    private Receta receta;*/
}