package S1.T3.n2.exercise1.src;

import S1.T3.n2.exercise1.src.classes.Restaurant;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurantHashSet = new HashSet<>();

        restaurantHashSet.add(new Restaurant("Telepathic", 5));
        restaurantHashSet.add(new Restaurant("Telepathic", 5));
        restaurantHashSet.add(new Restaurant("Telepathic", 8));

        restaurantHashSet.forEach(System.out::println);
    }
}
