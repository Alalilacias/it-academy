package S1.T8.n1.exercise3.src.classes;

import java.util.Arrays;
import java.util.List;

public class LambdaPrinter {
    private static final List<String> calendar = Arrays.asList(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December");
    @SuppressWarnings("Convert2MethodRef")
    protected static void calendarPrinter(){
        calendar.forEach(calendar -> System.out.println(calendar));
    }
}
