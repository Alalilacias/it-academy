package S1.T8.n2.exercise1.src.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    static List<String> nameList = Arrays.asList(
            "Alice", "Bob", "Charlie", "David", "Emma",
            "Frank", "Grace", "Henry", "Ivy", "Jack",
            "Kate", "Leo", "Mia", "Noah", "Olivia",
            "Peter", "Quinn", "Rachel", "Sam", "Tyler",
            "Ursula", "Vincent", "Wendy", "Xander", "Yasmine", "Zachary",
            "Ava", "Benjamin", "Chloe", "Daniel", "Ella",
            "Felix", "Georgia", "Hugo", "Isabel", "Jacob",
            "Katherine", "Liam", "Mila", "Nathan", "Sophia",
            "Oscar", "Penelope", "Quentin", "Rebecca", "Seth",
            "Tessa", "Ulysses", "Victoria", "William", "Ximena",
            "Yara", "Zane", "Abigail", "Blake", "Cassandra",
            "Dylan", "Emily", "Fiona", "Gavin", "Hannah",
            "Ian", "Jasmine", "Kevin", "Lily", "Mason",
            "Nora", "Owen", "Paige", "Quincy", "Riley",
            "Stella", "Tristan", "Uma", "Victor", "Willa",
            "Xavier", "Yvette", "Zara", "Adam", "Bella",
            "Caleb", "Diana", "Ethan", "Felicity", "George",
            "Harper", "Isla", "Jaxon", "Kylie", "Luna",
            "Maddox", "Natalie", "Oliver", "Piper", "Quinlan"
    );

    protected static void testExercise(){
        StringReturner(nameList).forEach(System.out::println);
    }

    private static List<String> StringReturner(List<String> list){
        return list.stream()
                .filter(listItem -> listItem.startsWith("A") && listItem.length() == 3)
                .collect(Collectors.toList());
    }
}
