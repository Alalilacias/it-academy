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

    private int potencia;

//    Constructor
    public Car(int potencia) {
        this.potencia = potencia;
    }

    //    Getters
    public int getPotencia() {
        return potencia;
    }
    public static String getModel() {
        return model;
    }

//    Setters
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public static void setModel(String model) {
        Car.model = model;
    }

//    User-defined methods
    public static void decelerate() {
        System.out.println("The vehicle is decelerating");
    }
    public void accelerate() {
        System.out.println("The vehicle is accelerating");
    }
}
