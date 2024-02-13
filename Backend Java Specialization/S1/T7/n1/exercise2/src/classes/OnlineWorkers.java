package S1.T7.n1.exercise2.src.classes;

public class OnlineWorkers extends Worker {
    private static final int internet = 25;

    public OnlineWorkers(String name, String surname, int pricePerHour) {
        super(name, surname, pricePerHour);
    }

    @Override
    public int calculateSalary(int hoursWorked) {
        return super.calculateSalary(hoursWorked) + internet;
    }

    @Deprecated
    public String pleadingForMercy(){
        return "Please, dear boss, I will work harder, don't lay me off.";
    }

    @Override
    public String toString() {
        return this.name + "'s salary for a 40h week would be " + calculateSalary(40) + "€";
    }
}
