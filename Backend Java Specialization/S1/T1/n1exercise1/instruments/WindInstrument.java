package S1.T1.n1exercise1.instruments;

public class WindInstrument extends Instrument {

//    Static block that will be initialized only upon first loading of the class
    static {
        System.out.println("The oldest woodwind musical instrument is dated to 43.000 years ago.");
    }

//    Constructor
    public WindInstrument(String name, int price) {
        super(name, price);
    }

//    User-defined Methods
    @Override
    public void play() {
        System.out.println("A sound instrument is playing");
    }
}
