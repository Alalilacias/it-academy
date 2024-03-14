package S3.T1.n3.src.receivers;

public class Ship implements Vehicle {
    @Override
    public void start() {
        System.out.println("Ship started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Ship accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Ship braking.");
    }
}
