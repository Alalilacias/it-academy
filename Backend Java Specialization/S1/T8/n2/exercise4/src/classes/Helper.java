package S1.T8.n2.exercise4.src.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Helper {

    static List<Object> randomList = Arrays.asList(
            "I procrastinated so hard",
            45,
            "I almost thought I wouldn't",
            1354891351354L,
            2.154_58e8,
            1.04f,
            "Finish it",
            6168741354638541351L,
            231531531.21354638613f,
            "I would input a discord :sweat_smile: emoji here if I knew how to",
            "RANDOMNUMBERTOBECAUGHTBYTHEISNUMERICMETHOD5"
    );

    protected static void testExercise(){
        randomList.stream()
                .map(Object::toString)
                .sorted(Comparator.comparingInt(s -> s.charAt(0)))
                .sorted(Comparator.comparing(s -> s.contains("e") ? 0 : 1))
                .map(s -> s.replace('a', '4'))
                .filter(s -> s.matches(".*\\d.*")).forEach(System.out::println);
    }
}
