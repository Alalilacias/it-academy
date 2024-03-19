package NonSprintEvaluations.Midterm03_19_2024.src.classes;

public class Clients {
    private final String name;
    private final String address;

    public Clients (String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client's name:" + name + ", address: " + address + ".";
    }
}
