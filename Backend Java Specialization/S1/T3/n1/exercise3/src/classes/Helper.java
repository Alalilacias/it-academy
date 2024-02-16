package S1.T3.n1.exercise3.src.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

    static Path pathToCountries = Paths.get("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T3\\n1\\exercise3\\src\\files\\countries.txt");
    static Path pathToScores = Paths.get("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T3\\n1\\exercise3\\src\\files\\score.txt");
    protected static void testExercise(){
        Map<String, String> countriesMap = downloadCountries();

        String[] userInfo = userQuiz(selectRandomNumberOfEntries(countriesMap, 10));
        saveScores(checkScore(userInfo));
    }

    private static Map<String, String> downloadCountries(){
        try (Stream<String> countryLines = Files.lines(pathToCountries)) {
                return countryLines.filter(line -> line.matches("[A-Za-z0-9]+ [A-Za-z0-9]+"))
                    .map(line -> line.split(" ", 2))
                    .filter(Helper::isValid)
                    .collect(Collectors.toMap(
                            Helper::getKey,
                            Helper::getValue
                    ));
        } catch (IOException e) {
            throw new RuntimeException("Error reading countries file or incorrect file path.");
        }
    }
    @SuppressWarnings("SameParameterValue")
    private static Map<String, String> selectRandomNumberOfEntries(Map<String, String> countriesMap, int numberOfEntries){
        return new Random().ints(0, countriesMap.size())
                .distinct().limit(numberOfEntries)
                .boxed()
                .map(index -> countriesMap.entrySet().stream().skip(index).findFirst().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    private static String[] userQuiz(Map<String, String> trimmedCountriesMap){
        Scanner scanner = new Scanner(System.in);

        String name;
        int points;

        System.out.println("Please introduce your name?");
        name = scanner.nextLine();
        points = trimmedCountriesMap.entrySet().stream()
                .mapToInt(country -> printQuestion(country, scanner))
                .sum();

        return new String[]{name, String.valueOf(points)};
    }
    private static int printQuestion(Map.Entry<String, String> country, Scanner scanner){
        System.out.print("What is the capital of " + country.getKey() + "?");

        if (scanner.nextLine().equals(country.getValue())){
            System.out.println("Correct, the capital of " + country.getKey() + " is " + country.getValue());
            return 1;
        } else {
            System.out.println("Incorrect, the capital of " + country.getKey() + " is " + country.getValue());
            return 0;
        }
    }
    private static Stream<String[]> checkScore(String[] currentUser){
        try (Stream<String> userScores = Files.lines(pathToScores)){

            List<String[]> userScoreList = new ArrayList<>(userScores
                    .map(savedUser -> savedUser.split("'s score: "))
                    .map(savedUserArray -> {

                        String savedUsername = savedUserArray[0];

                        int savedScore = Integer.parseInt(savedUserArray[1]);
                        int currentScore = Integer.parseInt(currentUser[1]);

                        if (savedUsername.equals(currentUser[0])) {

                            if (savedScore > currentScore || savedScore == currentScore) {
                                System.out.println("Score: " + currentScore + ". Not a high score.");
                                return new String[]{savedUsername, String.valueOf(savedScore)};
                            } else {
                                System.out.println("Score: " + currentScore + ". It's a high score!");
                                return new String[]{savedUsername, String.valueOf(currentScore)};
                            }
                        } else {
                            System.out.println("Score: " + currentScore + ". It's a high score!");
                            return new String[]{savedUsername, String.valueOf(savedScore)};
                        }
                    }).toList());

            boolean currentUserExists = userScoreList.stream()
                    .anyMatch(savedUserArray -> savedUserArray[0].equals(currentUser[0]));

            if (!currentUserExists) {
                userScoreList.add(new String[]{currentUser[0], currentUser[1]});
            }

            return userScoreList.stream();
        } catch (IOException e){
            throw new RuntimeException("Error when saving file, check the filepath to the high scores file.");
        }
    }
    private static void saveScores(Stream<String[]> userScores){
        try {
            Files.write(pathToScores, userScores
                    .map(userInfo -> userInfo[0] + "'s score: " + userInfo[1])
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    I wanted to do this with Lambdas and Stream API, but was having issues with the collect part of the
//    selectRandomNumberOfEntries() method, so I made these methods to help myself.
    private static String getKey(String[] lineArray){
        return lineArray[0].replace("_", " ").trim();
    }
    private static String getValue(String[] lineArray){
        return lineArray[1].replace("_", " ").trim();
    }
    private static boolean isValid(String[] lineArray){
        return lineArray.length == 2;
    }
}
