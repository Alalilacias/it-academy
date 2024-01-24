package S1.T1.n1.exercise2.src;

public class CarStore {

    public static void main(String[] args) {

//        Static method invocation, referencing superclass to clarify it's a class variable. Class is loaded.
        Car.decelerate();

        /* Static field with a getter accessed and printed directly after static method invocation.
        * Class being loaded after static method invocation allows for this, as explained in the Oracle Java Tutorials
        * The model is instantiated by a static block, so it can be changed afterward to showcase this precise phenomena */
        System.out.println(Car.getModel());

        /* Creation of instance of the car, final fields are automatically filled, and we use the constructor that allows
        * for modification of static field model whose value had been assigned via static block of code. */
        Car InstanceCar = new Car("Tiguan, MSRP");

//        Non-static method invocation, referencing instance of the class.
        InstanceCar.accelerate();

//        Invocation of toString() method to showcase changes and the correct storage of the class
        System.out.println(InstanceCar);
    }
}
