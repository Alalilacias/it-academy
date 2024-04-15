package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n03.S04T02N03AllegueAndres.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fruit")
public class Fruit {
    @Id
    private String id;

    private String name;
    private int quantityKilos;

    public Fruit() {
    }

    protected Fruit(String id){
        this.id = id;
    }

    public Fruit(String name, int quantityKilos){
        this.name = name;
        this.quantityKilos = quantityKilos;
    }

    public String getId() {
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantityKilos=" + quantityKilos +
                '}';
    }
}