package S1.T1.n1exercise1.instruments;

public abstract class Instrument {

//    Class variables
    private String name;
    private int price;

//    Constructors
    public Instrument() {
        this.name = "";
        this.price = 0;
    }
    public Instrument(String name, int price){
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

//    User-defined Methods
    public abstract void play();
    public String toString(){
        return "This instrument's name is " + this.name + ", it's price is " + this.price + "€.";
    }
}
