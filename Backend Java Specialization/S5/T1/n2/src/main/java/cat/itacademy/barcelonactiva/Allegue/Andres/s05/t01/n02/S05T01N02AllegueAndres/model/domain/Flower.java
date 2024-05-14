package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flowers")
@Entity
public class Flower {
    @Column(name = "idflowers", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "country", nullable = false, length = 45)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String country;

    public String updateName(String name){
        StringBuilder message = new StringBuilder("- name: ");

        if(!this.name.equals(name)){
            message
                    .append(this.name)
                    .append(" -> ")
                    .append(name);
            setCountry(name);
        } else {
            message.append("\n");
        }

        return message.toString();
    }

    public String updateCountry(String country){
        StringBuilder message = new StringBuilder("- Country: ");

        if(!this.country.equals(country)){
            message
                    .append(this.country)
                    .append(" -> ")
                    .append(country);
            setCountry(country);
        } else {
            message.append("\n");
        }

        return message.toString();
    }

    public FlowerDTO toDTO(){
        return FlowerDTO.builder()
                .id(id)
                .name(name)
                .country(country)
                .type(EuCountries.getFlowerType(country))
                .build();
    }
}
