package S1.T7.n1.exercise1.src.classes;

public abstract class Worker {
    protected String name;
    protected String surname;
    protected int pricePerHour;

    public Worker(String name, String surname, int pricePerHour){
        this.name = name;
        this.surname = surname;
        this.pricePerHour = pricePerHour;
    }

//    Return value made as int for simplicity of code in this case. In real life, double would be used.
public int calculateSalary(int hoursWorked){
        return hoursWorked * this.pricePerHour;
    }
}
