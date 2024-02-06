package S1.T3.n1.exercise3.src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner s = new Scanner(System.in);

        HashMap<String, String> countriesMap = fileReader();
        String[] countries = countriesMap.keySet().toArray(new String[10]);

        String name;
        String answer;

        int points = 0;

        System.out.println("Welcome, would you be so kind as to give me your name?");
        name = s.next();

        System.out.println("""
                Very well, let us start.
                I will give you the name of a country and I expect you to answer with it's capital.
                For each correct answer, you'll get a point. Press enter to start.""");
        s.nextLine();
        s.nextLine();

        for (int i = 0; i < 10; i++) {
            System.out.println("What is the capital of the country of " + countries[i] + "?");
            answer = s.next();
            if (answer.equalsIgnoreCase(countriesMap.get(countries[i]))) {
                System.out.println("Correct, the capital of " + countries[i] + " is " + countriesMap.get(countries[i]));
                points++;
            } else {
                System.out.println("Incorrect, the capital of " + countries[i] + " is " + countriesMap.get(countries[i]));
            }
        }

        System.out.println("Your total score is: " + points + ".");

        inputScore(name, points);
    }

    private static HashMap<String, String> fileReader() throws RuntimeException {

        HashMap<String, String> tempStringHashMap = new HashMap<>();

        try (Stream<String> countryLines = Files.lines(Paths.get("C:/Users/alleg/IdeaProjects/it-academy/Backend Java Specialization/S1/T3/n1/exercise3/src/files/countries.txt"))) {
            countryLines.forEach(line -> {
                String[] lineArray = line.split(" ", 2);
                lineArray[0] = lineArray[0].replace("_", " ");
                lineArray[1] = lineArray[1].replace("_", " ");
                tempStringHashMap.put(lineArray[0], lineArray[1]);
            });
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return tempStringHashMap;
    }
    private static void inputScore(String name, int score) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter("Backend Java Specialization/S1/T3/n1/exercise3/src/files/score.txt")) {
            out.println(name + "'s score: " + score);
        }
    }
}
