package S1.T3.n1.exercise3.src.classes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

//While I've modified the class to adapt it to some feedback I've gotte, I'll keep it in the code until I'm sure I won't
//need to check it, since the other one might have some issues that I could solve by checking this one
@SuppressWarnings("unused")
public class CountriesGamePoor {
    private static final HashMap<String, String> INSTANCE_MAP = fileReader();
    private static final List<String> INSTANCE_KEYS = INSTANCE_MAP.keySet().stream().toList();
    static String name;
    static int points;

    public CountriesGamePoor() {
        start();
    }

    public static void start () {
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
        SortedMap<String, Integer> scoreMap = new TreeMap<>();
        String[] tempArray;


        Path pointsPath = Path.of("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T3\\n1\\exercise3\\src\\files\\score.txt");

        String consoleText = "";
        String line;

        try (BufferedReader scoreReader = new BufferedReader(new FileReader(pointsPath.toFile()))){
            while ((line = scoreReader.readLine()) != null) {
                tempArray = line.replace("'s score:", "").split(" ");
                scoreMap.put(tempArray[0], Integer.valueOf(tempArray[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found, it doesn't exist or the route is incorrect.");
        }

        if (!scoreMap.containsKey(name)) {
            consoleText = "You have set your first record at " + points + " points";
            scoreMap.put(name, points);
        } else {
            if(scoreMap.get(name) > points){
                consoleText = "You have gotten a score below your high score, good luck next time.";
            } else if(scoreMap.get(name) == points){
                consoleText = "You have matched your high score, well done.";
            } else if(scoreMap.get(name) < points) {
                consoleText = "Congrats, you've surpassed your high score!";
                scoreMap.put(name, points);
            }
        }

        try{
            Files.delete(pointsPath);
        } catch (IOException e) {
            throw new RuntimeException();
        }

        try (PrintWriter out = new PrintWriter("Backend Java Specialization/S1/T3/n1/exercise3/src/files/score.txt")) {
            for (String key : scoreMap.keySet()) {
                out.println(key + "'s score: " + scoreMap.get(key));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }

        System.out.println(consoleText);
    }
}
