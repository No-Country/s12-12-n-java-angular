import jakarta.persistence.*;
import lombok.*;

@Table(name = "historial")
@Entity(name = "historial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Hitorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "historial")
    private String historial;
}