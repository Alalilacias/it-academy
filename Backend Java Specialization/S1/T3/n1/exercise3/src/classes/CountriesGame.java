package S1.T3.n1.exercise3.src.classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class CountriesGame {
    private static final HashMap<String, String> INSTANCE_MAP = fileReader();
    private static final List<String> INSTANCE_KEYS = INSTANCE_MAP.keySet().stream().toList();
    static String name;
    static int points;

    public static void start (){
        consoleInteractions();
        pointsSave();
    }
    private static HashMap<String, String> fileReader() throws RuntimeException {
//        Method variables instantiation
        HashMap<String, String> tempStringHashMap = new HashMap<>();
        HashMap<String, String> returningStringHashMap = new HashMap<>();
//        Map filling and correction.
        try (Stream<String> countryLines = Files.lines(Paths.get("C:/Users/alleg/IdeaProjects/it-academy/Backend Java Specialization/S1/T3/n1/exercise3/src/files/countries.txt"))) {
            countryLines.forEach(line -> {
                String[] lineArray = line.split(" ", 2);
                lineArray[0] = lineArray[0].replace('_', ' ').trim();
                lineArray[1] = lineArray[1].replace('_', ' ').trim();
                tempStringHashMap.put(lineArray[0], lineArray[1]);
            });
        } catch (IOException e) {
            throw new RuntimeException();
        }
//        Key assignment to an external String Array
        String[] keyList = tempStringHashMap.keySet().toArray(new String[0]);
//        Assignment of ten random key-value pairs to the returningStringHashMap, which is then returned
        for (int i = (int) (Math.random() * 51); returningStringHashMap.size() < 10; i = (int) (Math.random() * 51)) {
            returningStringHashMap.put(keyList[i], tempStringHashMap.get(keyList[i]));
        }

        return returningStringHashMap;
    }
    private static void consoleInteractions() {
        Scanner s = new Scanner(System.in);

        String answer;

        System.out.println("Welcome, introduce your name:");
        name = s.nextLine();

        System.out.println("Prepare for questioning, " + name + ". Press enter when ready.");
        s.nextLine();
        s.nextLine();

        for (String key : INSTANCE_KEYS){
            System.out.println("Introduce the capital of " + key + ":");
            answer = s.nextLine();
            if (answer.equals(INSTANCE_MAP.get(key))) {
                System.out.println("Correct, the capital of " + key + " is " + INSTANCE_MAP.get(key));
                points++;
            } else {
                System.out.println("Incorrect, the capital of " + key + " is " + INSTANCE_MAP.get(key));
            }
        }
    }
    private static void pointsSave() {
        String textToSave;

        try (Stream<String> scoreLines = Files.lines(Paths.get("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T3\\n1\\exercise3\\src\\files\\score.txt"))) {
            if (scoreLines.findAny().isEmpty()) {
                scoreLines.forEach(line -> {

                });
            } else {

            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
