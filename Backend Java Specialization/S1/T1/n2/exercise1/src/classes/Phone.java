package S1.T1.n2.exercise1.src.classes;

public abstract class Phone {
//    Instance variables
    protected String make;
    protected String model;

//    Constructors
    public Phone (String make, String model) {
        this.make = make;
        this.model = model;
    }

//    User-defined method
    public String call(String dialNumber) {
        return "Calling " + dialNumber + ".";
    }
}
