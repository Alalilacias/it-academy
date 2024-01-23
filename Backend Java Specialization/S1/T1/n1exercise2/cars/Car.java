package S1.T1.n1exercise2.cars;

import java.lang.reflect.Constructor;

public abstract class Car {

//    Class variables
    private static final String MARCA = "Volkswagen";
    private static String model;
    private int potencia;

//    Constructor
    public Car(String modelName, int potencia) {
        model = modelName;
        this.potencia = potencia;
    }

//    Getters
    public int getPotencia() {
        return potencia;
    }

//    Setters
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

//    User-defined methods
    public static void decelerate() {
        System.out.println("The vehicle is decelerating");
    }
    public void accelerate() {
        System.out.println("The vehicle is accelerating");
    }
}
