package S1.T3.n1.exercise3.src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Throwable {
//        Scanner instantiation
        Scanner s = new Scanner(System.in);

//        Hashmap creation using the method fileReader, which reads the countries.txt file and fills a map.
        HashMap<String, String> countriesMap = fileReader();
//        String array filled with the keys of the countries in the hashmap
        String[] countries = countriesMap.keySet().toArray(new String[10]);
//        Instance variables to store player name and their different answers. As well as their point total.
        String name;
        String answer;

        int points = 0;
//        Initial questioning of the player to obtain name and to give explanation of the game.
        System.out.println("Welcome, would you be so kind as to give me your name?");
        name = s.next();

        System.out.println("""
                Very well, let us start.
                I will give you the name of a country and I expect you to answer with it's capital.
                For each correct answer, you'll get a point. Press enter to start.""");
        s.nextLine();
        s.nextLine();
        /*Printing of the questions via console, filling of the answer variable by user, collation by the machine with the
        * hashMap to confirm the correctness or lack thereof of the user's answers and annotation of the user's points.*/
        for (int i = 0; i < 10; i++) {
            System.out.println("What is the capital of the country of " + countries[i] + "?");
            answer = s.nextLine();
            if (answer.equals(countriesMap.get(countries[i]).trim())) {
                System.out.println("Correct, the capital of " + countries[i] + " is " + countriesMap.get(countries[i]));
                points++;
            } else {
                System.out.println("Incorrect, the capital of " + countries[i] + " is " + countriesMap.get(countries[i]));
            }
        }
//        Total score is printed by console for the user to see
        System.out.println("Your total score is: " + points + ".");
//        Total score is recorded in the score.txt file
        inputScore(name, points);
    }

    /* fileReader() method reads the lines of the countries.txt file and splits them into keys and values of a map.
    *  The map is then corrected, replacing the underscores that are meant to separate keys and values by an actual space
    *  so the user's answers are counted as correct, and trimmed.
    *  Ten key-value pairs of the corrected map are then assigned to a reducedMap that will be returned to the main method,
    *  assuring different questions every time. */
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
//    Input score stores the user's score into the text file. Due to time constraints, a sorter using date and score wasn't included.
    private static void inputScore(String name, int score) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter("Backend Java Specialization/S1/T3/n1/exercise3/src/files/score.txt")) {
            out.println(name + "'s score: " + score );
        }
    }
}
