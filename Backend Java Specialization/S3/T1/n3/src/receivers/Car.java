package S3.T1.n3.src.receivers;

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Car accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Car braking.");
    }
}
