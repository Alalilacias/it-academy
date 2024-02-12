package S1.T5.n1.exercise2.src.classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public final class DirectoryReaderAuxiliary {
    //        String variable to hold the text to print on console
    static String consoleText = "The directory contains the following files, sorted in alphabetical order:\n";
    public static void DirectoryReader(String path) {
//        Directory and variable instantiation
        File directory = new File(path);

//        Check that the path brings to a directory
        if (!directory.isDirectory()) {
            System.out.println("The path given doesn't contain a directory");
            return;
        }

//        Recursively list the contents of the directory, following the assignment instructions.
        recursiveContentsReader(directory, 0);

//        Print results to console
        System.out.println(consoleText);
    }

    public static void recursiveContentsReader(File directory, int depth) {
        try {
//        Date format to format the last modified date and depth for visual clarity. Took out seconds because I prefer it that way.
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
}