package S1.T1.n2.exercise1.src;

import S1.T1.n2.exercise1.src.classes.Smartphone;

public class Main {
    public static void main(String[] args) {

        Smartphone mi = new Smartphone("Xiaomi Redmi", "Note 10");

        System.out.println(mi.call("616323484"));

        System.out.println(mi.photograph());

        System.out.println(mi.alarm());
    }
}
