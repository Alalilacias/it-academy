package S1.T3.n1.exercise1.src;

import S1.T3.n1.exercise1.src.classes.Month;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calendar {
    public static void main(String[] args) {
        List<Month> calendar = Stream.of(
                new Month("January"),
                new Month("February"),
                new Month("March"),
                new Month("April"),
                new Month("May"),
                new Month("June"),
                new Month("July"),
                new Month("September"),
                new Month("October"),
                new Month("November"),
                new Month("December")
        ).collect(Collectors.toList());

        calendar.add(7, new Month("August"));

        calendar.forEach(System.out::println);

        Set<Month> calendarSet = new HashSet<>(calendar);
//        Confirmation that the hashset doesn't allow for duplicates
        calendarSet.add(new Month("August"));
        calendarSet.add(new Month("May"));

//        Going through the list with a for loop
        for (Month month : calendar) {
            month.setName(month.getName().toLowerCase());
        }
//        going through the list with an iterator
        Iterator<Month> iterator = calendar.iterator();
        //noinspection WhileLoopReplaceableByForEach
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }

}
