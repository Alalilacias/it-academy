package S1.T5.n1.exercise1.src.classes;

import java.io.File;
import java.util.Arrays;

public final class DirectoryReaderAuxiliary {
    public static void DirectoryReader(String path) {
//        Directory and variable instantiation
        File directory = new File(path);

        String consoleText = "The directory contains the following files, sorted in alphabetical order:\n";

//        Check that the path brings to a directory
        if (!directory.isDirectory()) {
            System.out.println("The path given doesn't contain a directory");
            return;
        }

//        File extraction into a file Array
        File[] files = directory.listFiles();

        assert files != null;
        if (files.length < 1) {
            System.out.println("The directory doesn't contain any files.");
        }

//        File sorting alphabetically
        Arrays.sort(files);

        for (File file : files) {
            consoleText = consoleText.concat("- " + file.getName() + ".\n");
        }

        System.out.println(consoleText);
    }
}