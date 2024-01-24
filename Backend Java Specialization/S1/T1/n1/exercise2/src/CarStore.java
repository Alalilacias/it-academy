package S1.T1.n1.exercise2.src;

public class CarStore {

    public static void main(String[] args) {

//        Creation of an instance of the car. Brand and model are automatically filled, being static final and static.
        Car InstanceCar = new Car(250);

//        Static method invocation, referencing superclass to clarify it's a class variable.
        Car.decelerate();

//        Non-static method invocation, referencing instance of the class.
        InstanceCar.accelerate();
    }
}
