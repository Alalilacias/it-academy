package S3.T1.n3.src.commands;

import S3.T1.n3.src.receivers.Vehicle;

public class Accelerate implements Command {

    private final Vehicle vehicle;

    public Accelerate (Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public void execute() {
        vehicle.accelerate();
    }
}
