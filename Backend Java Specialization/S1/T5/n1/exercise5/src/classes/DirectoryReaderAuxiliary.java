package S1.T5.n1.exercise5.src.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public final class DirectoryReaderAuxiliary {
//    String variable to hold the text to print on console
    static String consoleText = "The directory contains the following files, sorted in alphabetical order:\n";
    static String fileText = "The file you've requested a reading of, says:\n";
//    SimpleDateFormat for date form control. Took out seconds because I prefer it that way.
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm.");
    public static void DirectoryReader(String directoryPath, String savePath) {
//        Modification of the date consoleText variable to adapt to the current update of the .txt file
        consoleText = ("Reading of file found at " + directoryPath + ".\n" +
                "Date of the reading: " + dateFormat.format(new Date()) + "\n").concat(consoleText);
//        Directory and variable instantiation
        File directory = new File(directoryPath);

//        Check that the directoryPath brings to a directory
        if (!directory.isDirectory()) {
            System.out.println("The directoryPath given doesn't contain a directory");
            return;
        }

//        Recursively list the contents of the directory, following the assignment instructions.
        recursiveContentsReader(directory, 0);

//        Last paragraph change to make sure the inputs on the file are distinguishable
        consoleText = consoleText.concat("\n");
//        Results saved to a txt file
        saveInFile(savePath);
    }

    private static void recursiveContentsReader(File directory, int depth) {
        try {
//        Tabulations variable for visual clarity.
            String tabulations = ("\t").repeat(depth);
//        File extraction into a file Array
            File[] files = directory.listFiles();

//        Confirm that the array, the directory by extension, isn't empty.
            assert files != null;
            if (files.length < 1) {
                consoleText = consoleText.concat(tabulations + "- The directory doesn't contain any files.\n");
                return;
            }

//        File sorting alphabetically
            Arrays.sort(files);

            for (File file : files) {
                if (file.isDirectory()) {
                    consoleText = consoleText.concat(tabulations + "- " + file.getName() + "(D)." +
                            "Last modified: " + dateFormat.format(new Date(file.lastModified())) + "\n");
                    recursiveContentsReader(new File(file.getAbsolutePath()), (depth + 1));
                } else {
                    consoleText = consoleText.concat(tabulations + "- " + file.getName() + "(F)." +
                            "Last modified: " + dateFormat.format(new Date(file.lastModified())) + "\n");
                }
            }

        } catch (NullPointerException e) {
            System.out.println("Provided path doesn't exist or is incorrect.");
        }
    }
    private static void saveInFile(String path) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(consoleText);
            System.out.println("Result saved correctly.");
        } catch (IOException e) {
            System.out.println("The named file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason.");
        }
    }
    public static void readTextFile(String path) {
        File file = new File(path);

//        Check validity of the text file
        if ((!file.isFile()) || (!file.getName().toLowerCase().endsWith(".txt"))) {
            System.out.println("The path provided does not contain a valid TXT file.");
            return;
        }

//        File reading and saving in the variable
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.readLine() != null) {
                fileText = fileText.concat(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("The path given does not contain a readable file.");
        }

//        Printing of the result by console
        System.out.println(fileText);
    }
    public static void serialize(E5Object object, String serializationPath){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(serializationPath))){
            outputStream.writeObject(object);
            System.out.println("Object serialized correctly.");
        } catch (IOException e) {
            System.out.println("Error on object serialization.");
        }
    }
    public static void deserialize(String serializationPath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(serializationPath))){
            Object object = inputStream.readObject();
            if (object instanceof E5Object){
                System.out.println(object);
            } else {
                System.out.println("This object you're trying to deserialize isn't an allowed one.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error on object deserialization.");
        }
    }
}