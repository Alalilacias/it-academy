package S1.T3.n2.exercise2.src;

import S1.T3.n2.exercise2.src.classes.Restaurant2;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Restaurant2> restaurantHashSet = new TreeSet<>();

        restaurantHashSet.add(new Restaurant2("Telepathic", 5));
        restaurantHashSet.add(new Restaurant2("Telepathic", 5));
        restaurantHashSet.add(new Restaurant2("Telepathic", 8));
        restaurantHashSet.add(new Restaurant2("Telepathic", 9));
        restaurantHashSet.add(new Restaurant2("Telepathic", 1));

        restaurantHashSet.forEach(System.out::println);
    }
}
