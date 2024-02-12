package S1.T5.n1.exercise1.src;

import S1.T5.n1.exercise1.src.classes.DirectoryReaderAuxiliary;

public class MainS1T4n1e1 {
    public static void main(String[] args) {
//        Check there's one argument, the path. Remind user of instructions if not.
        if (args.length != 1) {
            System.out.println("To use this file, the correct command is as follows: java MainS1T4n1e1.java <directory_path>");
            System.exit(1);
        }

//        Extract arguments into a string to transfer to method
        String directoryPath = args[0];

//        Execute DirectoryReader() method.
        DirectoryReaderAuxiliary.DirectoryReader(directoryPath);

//        Code used for testing purposes, commented, so it doesn't affect the correct working of the program
//        DirectoryReaderAuxiliary.DirectoryReader("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T5\\n1\\exercise1\\src\\files");
    }
}
