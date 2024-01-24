package S1.T1.n1.exercise1.src.subclasses;

import S1.T1.n1.exercise1.src.superclass.Instrument;

public class PercussionInstrument extends Instrument {

//    Constructor
    public PercussionInstrument(String name, int price) {
        super(name, price);
    }

//    User-defined methods
    @Override
    public void play() {
        System.out.println("A percussion instrument is playing");
    }
}
