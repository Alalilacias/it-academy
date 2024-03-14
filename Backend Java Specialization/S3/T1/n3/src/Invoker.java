package S3.T1.n3.src;

import S3.T1.n3.src.commands.Brake;
import S3.T1.n3.src.commands.Accelerate;
import S3.T1.n3.src.commands.Command;
import S3.T1.n3.src.commands.Start;

public class Invoker {
    private final Command accelerateCommand;
    private final Command brakeCommand;
    private final Command startCommand;

    public Invoker (Accelerate accelerate, Brake brake, Start start) {
        this.accelerateCommand = accelerate;
        this.brakeCommand = brake;
        this.startCommand = start;
    }

    public void accelerateVehicle(){
        accelerateCommand.execute();
    }
    public void brakeVehicle(){
        brakeCommand.execute();
    }
    public void startVehicle(){
        startCommand.execute();
    }
}
