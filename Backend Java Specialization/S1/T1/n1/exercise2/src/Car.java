package S1.T1.n1.exercise2.src;

public class Car {

//    Class variables
    private static final String BRAND = "Volkswagen";
    private static String model;

    /* Class variable is assigned a value in a static block to make sure it isn't empty in case user tries to invoke
    * getModel() method.
    */
    static {
        model = "Atlas, MSRP";
    }

    private final int HORSEPOWER = 250;

//    Constructors
    public Car(String model){
        Car.model = model;
    }

    //    Getters
    public static String getModel() {
        return model;
    }

//    User-defined methods
    public static void decelerate() {
        System.out.println("The vehicle is decelerating");
    }
    public void accelerate() {
        System.out.println("The vehicle is accelerating");
    }
    public String toString(){
        return "This vehicle's brand is " + BRAND + ", it's model is " + model + ", and it has a horsepower of " +
                HORSEPOWER + ".";
    }
}
