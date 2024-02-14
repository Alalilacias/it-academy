package S1.T8.n2.exercise2.src.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    static List<Integer> randomNumbers = Arrays.asList(
            3, 55, 44, 12, 87, 6, 98, 23, 1, 72,
            5, 64, 37, 99, 14, 81, 46, 10, 29, 52,
            73, 68, 17, 90, 42, 8, 61, 93, 25, 78,
            49, 20, 34, 67, 19, 84, 53, 7, 96, 31,
            58, 11, 74, 23, 35, 2, 89, 50, 13, 76,
            28, 41, 63, 95, 22, 59, 4, 30, 66, 21,
            83, 56, 9, 37, 75, 18, 45, 88, 27, 62,
            40, 77, 16, 98, 33, 55, 12, 70, 44, 81,
            14, 51, 94, 39, 72, 5, 60, 92, 26, 69,
            32, 57, 80, 15, 38, 79, 24, 71, 48, 91
    );
    protected static void testExercise(){
        System.out.println(myStringBuilder(randomNumbers));
    }

    private static String myStringBuilder(List<Integer> integerList){
        return integerList.stream()
                .map(number -> (number % 2 ==0 ? "e" : "o") + number)
                .collect(Collectors.joining(", "));
    }
}
