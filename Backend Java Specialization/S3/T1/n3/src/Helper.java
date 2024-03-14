package S3.T1.n3.src;

import S3.T1.n3.src.commands.Brake;
import S3.T1.n3.src.commands.Accelerate;
import S3.T1.n3.src.commands.Start;
import S3.T1.n3.src.receivers.Bike;
import S3.T1.n3.src.receivers.Car;
import S3.T1.n3.src.receivers.Plane;
import S3.T1.n3.src.receivers.Ship;

//  This class acts as the client class in the command design pattern.
public class Helper {
    public static void testExercise(){
        Bike bike = new Bike();
        Car car = new Car();
        Plane plane = new Plane();
        Ship ship = new Ship();

        Invoker bikeInvoker = new Invoker(new Accelerate(bike), new Brake(bike), new Start(bike));
        Invoker carInvoker = new Invoker(new Accelerate(car), new Brake(car), new Start(car));
        Invoker planeInvoker = new Invoker(new Accelerate(plane), new Brake(plane), new Start(plane));
        Invoker shipInvoker = new Invoker(new Accelerate(ship), new Brake(ship), new Start(ship));

//        Bike
        bikeInvoker.startVehicle();
        bikeInvoker.accelerateVehicle();
        bikeInvoker.brakeVehicle();

//        Car
        carInvoker.startVehicle();
        carInvoker.accelerateVehicle();
        carInvoker.brakeVehicle();

//        Plane
        planeInvoker.startVehicle();
        planeInvoker.accelerateVehicle();
        planeInvoker.brakeVehicle();

//        Ship
        shipInvoker.startVehicle();
        shipInvoker.accelerateVehicle();
        shipInvoker.brakeVehicle();
    }
}