package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.UserRoles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@Schema($schema = "Entity for the users.")
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "users")
public class User {
    @Column(name = "idusers", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Schema(description = "Self-explanatory")
    private int id;

    @Column(name = "username", nullable = false, unique = true, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    @NotEmpty(message = "Please enter a username.")
    private String username;

    @Column(name = "email", nullable = false, length = 100)
    @Email(message = "Please enter a valid email.")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @NotEmpty(message = "Please enter an email")
    @Schema(description = "Self-explanatory")
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @NotEmpty(message = "Please enter a password")
    @Schema(description = "Self-explanatory")
    private String password;

    @Column(name = "roles", nullable = false, length = 64)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    private String roles;

    @Column(name = "profile_pic")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    private String profile_pic;
}
