package S3.T1.n3.src.receivers;

public class Plane implements Vehicle {

    @Override
    public void start() {
        System.out.println("Plane started.");
    }

    @Override
    public void accelerate() {
        System.out.println("Plane accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Plane braking.");
    }
}
