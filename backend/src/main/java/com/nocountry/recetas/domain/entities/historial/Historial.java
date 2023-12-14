package com.nocountry.recetas.domain.entities.historial;

import com.nocountry.recetas.domain.entities.receta.Receta;
import com.nocountry.recetas.domain.entities.usr.Usr;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "historial")
@Entity(name = "Historial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Historial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Receta receta;

    @OneToMany(
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        cascade = CascadeType.ALL,
        mappedBy = "historial"
    )
    private List<Usr> users;
}
