package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_name")
    private FruitTypes name;

    @Column(name = "quantity_kilos")
    private int quantityKilos;

    protected Fruit(){}
    public Fruit(FruitTypes type, int quantityKilos){
        this.name = type;
        this.quantityKilos = quantityKilos;
    }

    public long getId() {
        return id;
    }
    public FruitTypes getName() {
        return name;
    }
    public int getQuantityKilos() {
        return quantityKilos;
    }

    public void setName(FruitTypes name) {
        this.name = name;
    }
    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }
}