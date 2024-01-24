package S1.T1.n1exercise1;

import S1.T1.n1exercise1.instruments.Instrument;
import S1.T1.n1exercise1.instruments.PercussionInstrument;
import S1.T1.n1exercise1.instruments.StringInstrument;
import S1.T1.n1exercise1.instruments.WindInstrument;

public class InstrumentStore {
    public static void main(String[] args) {

//        Printing of the static variable created for the Instrument class, allowing the initial loading of the class by the
//        access to a member of it. It will print the static block's content first, then the static member we invoked.
        System.out.println(Instrument.getMusicalScale());

//        Creation of the first instance of the class, it'll print the static block of the class while doing so.
        WindInstrument Flute = new WindInstrument("Flute", 35);
//        Creation of reminding classes, with no static or non-static blocks.
        StringInstrument Viola = new StringInstrument("Viola", 5000);
        PercussionInstrument Gong = new PercussionInstrument("Gong", 500);

//        Showcase of the methods of the classes.
        Flute.play();
        System.out.println(Flute);

        Viola.play();
        System.out.println(Viola);

        Gong.play();
        System.out.println(Gong);
    }
}
