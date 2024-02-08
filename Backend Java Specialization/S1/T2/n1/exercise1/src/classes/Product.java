package S1.T2.n1.exercise1.src.classes;

public class Product {
//    Instance variables. Int is chosen for price for efficiency and to simplify the exercise.
    private String name;
    private int price;
//    Constructors
    public Product (String name, int price){
        this.name = name;
        this.price = price;
    }
//    Getters
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
//    Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
