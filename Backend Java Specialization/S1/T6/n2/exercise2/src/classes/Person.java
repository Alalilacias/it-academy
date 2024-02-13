package S1.T6.n2.exercise2.src.classes;

public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "The person this object represents' name is " + this.firstName + " " + this.lastName + ", they're " + this.age + "years old.";
    }
}
