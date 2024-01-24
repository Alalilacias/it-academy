package S1.T1.n1exercise1.instruments;

public abstract class Instrument {

//    Static block that will be initialized only upon first loading of the class
    static {
        System.out.println("The oldest musical instrument discovered so far is a Neanderthal flute from 60.000 years ago.");
    }
//    Class variables
    private String name;
    private int price;
    private static String musicalScale = "C-";

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
    public static String getMusicalScale() {
        return musicalScale;
    }

//    Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public static void setMusicalScale(String musicalScale) {
        Instrument.musicalScale = musicalScale;
    }

//    User-defined Methods
    public abstract void play();
    public String toString(){
        return "This instrument's name is " + this.name + ", it's price is " + this.price + "€.";
    }
}
