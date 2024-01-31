package S1.T3.n1.exercise2.src;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Initial List Instantiation.
        List<Integer> initialList = Stream.of(5, 2, 6, 7, 9, 3, 4, 1, 8).toList();
//        Reversed list and ListIterator instantiation.
        List<Integer> reversedList = new ArrayList<>();
        ListIterator<Integer> integerListIterator = initialList.listIterator(initialList.size());
//        reversedList filling using the ListIterator
        while (integerListIterator.hasPrevious()) {
            reversedList.add(integerListIterator.previous());
        }
//        Printing by console to confirm the list has been reversed.
        Stream.of(reversedList).forEach(System.out::println);
    }
}
