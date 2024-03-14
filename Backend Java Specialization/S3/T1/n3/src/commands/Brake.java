package S3.T1.n3.src.commands;

import S3.T1.n3.src.receivers.Vehicle;

public class Brake implements Command {
    private final Vehicle vehicle;

    public Brake (Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public void execute() {
        vehicle.brake();
    }
}
