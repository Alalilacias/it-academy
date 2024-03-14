package S3.T1.n3.src.receivers;

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Bike braking.");
    }
}
