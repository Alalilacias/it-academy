package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n01.S04T02N01AllegueAndres.model.domain;

import jakarta.persistence.*;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fruit_name")
    private String name;

    @Column(name = "quantity_kilos")
    private int quantityKilos;

    public Fruit() {
    }

    protected Fruit(long id){
        this.id = id;
    }
    public Fruit(String name, int quantityKilos){
        this.name = name;
        this.quantityKilos = quantityKilos;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantityKilos() {
        return quantityKilos;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name=" + name +
                ", quantityKilos=" + quantityKilos +
                '}';
    }
}