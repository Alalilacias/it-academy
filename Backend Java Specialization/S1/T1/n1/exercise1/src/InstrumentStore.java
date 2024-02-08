package S1.T1.n1.exercise1.src;

import S1.T1.n1.exercise1.src.superclass.Instrument;
import S1.T1.n1.exercise1.src.subclasses.PercussionInstrument;
import S1.T1.n1.exercise1.src.subclasses.StringInstrument;
import S1.T1.n1.exercise1.src.subclasses.WindInstrument;

public class InstrumentStore {
    public static void main(String[] args) {

//        Printing of the static variable created for the Instrument class, allowing the initial loading of the class by the
//        access to a member of it. It will print the static block's content first, then the static member we invoked.
        System.out.println(Instrument.getMusicalScale());

//        Creation of the first instance of the class, it'll print the static block of the class while doing so.
        WindInstrument flute = new WindInstrument("Flute", 35);
//        Creation of reminding classes, with no static or non-static blocks.
        StringInstrument viola = new StringInstrument("Viola", 5000);
        PercussionInstrument gong = new PercussionInstrument("Gong", 500);

//        Showcase of the instance methods.
        flute.play();
        System.out.println(flute);

        viola.play();
        System.out.println(viola);

        gong.play();
        System.out.println(gong);
    }
}
