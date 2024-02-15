package S1.T8.n2.exercise4.src.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
            "03151631513681"
    );

    protected static void testExercise(){
        sortAlphabetically(randomList).forEach(System.out::println);
        System.out.println("\n");
        sortByContainingE(randomList).forEach(System.out::println);
        System.out.println("\n");
        changeAsFor4s(randomList).forEach(System.out::println);
        System.out.println("\n");
        filterAndPrintNumerics(randomList).forEach(System.out::println);
    }

    private static List<Object> sortAlphabetically(List<Object> list){
        return list.stream()
                .map(Object::toString)
                .sorted(Comparator.comparingInt(s -> s.charAt(0)))
                .collect(Collectors.toList());
    }
    private static List<Object> sortByContainingE(List<Object> list){
        return list.stream()
                .map(Object::toString)
                .sorted(Comparator.comparing(s -> s.toLowerCase().contains("e") ? 0 : 1))
                .collect(Collectors.toList());
    }
    private static List<Object> changeAsFor4s(List<Object> list){
        return list.stream()
                .map(Object::toString)
                .map(s -> s.replace("a", "4"))
                .collect(Collectors.toList());

    }
    private static List<Object> filterAndPrintNumerics(List<Object> list){
        return list.stream()
                .filter(item -> item instanceof Number || item.toString().matches("^-?\\d+(\\.\\d+)?$\n"))
                .collect(Collectors.toList());
    }
}
