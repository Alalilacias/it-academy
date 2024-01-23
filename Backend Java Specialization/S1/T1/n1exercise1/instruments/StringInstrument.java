package S1.T1.n1exercise1.instruments;

public class StringInstrument extends Instrument {

//    Constructor
    public StringInstrument(String name, int price) {
        super(name, price);
    }

//    User-defined methods
    @Override
    public void play() {
        System.out.println("A string instrument is playing");
    }
}
