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
//        Instance variable used to store the month names to print.
        StringBuilder text = new StringBuilder();
//        List instantiation using ArrayList as a base.
        List<Month> calendar;
//        Addition of only eleven out of twelve months, leaving out August, to the List.
        calendar = Stream.of(
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
//        Addition of the August Month in its place according to our calendar.
        calendar.add(7, new Month("August"));
//        Confirmation of the correct insertion of August Month into the ArrayList at the requested place.
        for (Month month : calendar) {
            text.append(month.getName()).append("\n");
        }
        System.out.println(text);
//        Instantiation of hashset using ArrayList as a base
        Set<Month> calendarSet = new HashSet<>(calendar);
//        Confirmation that the hashset doesn't allow for duplicates
        calendarSet.add(new Month("August"));
        calendarSet.add(new Month("May"));
        text = new StringBuilder();
        for (Month month : calendarSet){
            text.append(month.getName()).append("\n");
        }
        System.out.println(text);
//        Going through the list with a for loop
        for (Month month : calendar) {
            month.setName(month.getName().toLowerCase());
        }
//        going through the list with an iterator
        Iterator<Month> iterator = calendar.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }

}
