package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    I would make an enum here and limit the users choices, but alas
    @Column(name = "fruit_name")
    private String name;
    @Column(name = "quantity_kilos")
    private int quantityKilos;
}