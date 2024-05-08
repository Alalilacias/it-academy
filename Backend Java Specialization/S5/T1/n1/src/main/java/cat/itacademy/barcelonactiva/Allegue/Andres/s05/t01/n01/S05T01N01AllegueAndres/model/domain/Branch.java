package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@Schema($schema = "Entity for the branches.")
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "branches")
@SuppressWarnings("unused")
public class Branch {
    @Column(name = "idbranches", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Schema(description = "Self-explanatory")
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    private String name;

    @Column(name = "country", nullable = false, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    private String country;
}