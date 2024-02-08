package S1.T1.n2.exercise1.src.classes;

public class Smartphone extends Phone implements Camera, Clock {
//    Constructor
    public Smartphone(String make, String model) {
        super(make, model);
    }
//    User-defined methods. Chose String returns for testing purposes.
    @Override
    public String photograph() {
        return "A picture is being taken.";
    }

    @Override
    public String alarm() {
        return "The alarm is ringing.";
    }
}
