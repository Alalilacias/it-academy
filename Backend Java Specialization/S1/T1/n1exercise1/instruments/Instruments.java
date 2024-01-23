package S1.T1.n1exercise1.instruments;

public abstract class Instruments {

//    Class variables
    private String name;
    private int price;

//    Constructors
    public Instruments () {
        this.name = "";
        this.price = 0;
    }
    public Instruments (String name, int price){
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

//    Methods
    public abstract void play();

    public String toString(){
        String s = "This instrument's name is " + this.name + ", it's price is " + this.price + "€";
        return s;
    }
}
