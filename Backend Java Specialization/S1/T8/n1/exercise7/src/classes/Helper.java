package S1.T8.n1.exercise7.src.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Helper {
    static List<Object> randomList = Arrays.asList(
            5,
            "I'm not sure",
            9.4,
            "I correctly understood this exercise",
            255.1,
            't',
            "his",
            1318613516384635133.38415351968131531,
            "..",
            'U'
    );
    protected static void testExercise(){
        randomList.stream()
                .map(Object::toString)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);
    }
}
