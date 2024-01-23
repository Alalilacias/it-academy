package S1.T1.n1exercise1.instruments;

public class WindInstrument extends Instrument {

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
