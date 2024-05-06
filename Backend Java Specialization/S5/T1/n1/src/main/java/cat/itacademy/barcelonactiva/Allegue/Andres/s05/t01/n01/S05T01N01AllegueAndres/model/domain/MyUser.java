package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums.UserRoles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Schema($schema = "Entity for the users.")
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class MyUser implements UserDetails {
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
    @Enumerated(EnumType.ORDINAL)
    @Schema(description = "Self-explanatory")
    private UserRoles roles;

    @Column(name = "profile_pic")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Schema(description = "Self-explanatory")
    private String profile_pic;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
//        No logic for now, modify as needed
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
//        No logic for now, modify as needed
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
//        No logic for now, modify as needed
        return true;
    }

    @Override
    public boolean isEnabled() {
//        No logic for now, modify as needed
        return true;
    }
}