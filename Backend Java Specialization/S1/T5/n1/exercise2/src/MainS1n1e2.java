package S1.T5.n1.exercise2.src;

import S1.T5.n1.exercise2.src.classes.DirectoryReaderAuxiliary;

public class MainS1n1e2 {
    public static void main(String[] args) {
//        Check there's one argument, the path. Remind user of instructions if not.
        if (args.length != 1) {
            System.out.println("To use this file, the correct command is as follows: java MainS1n1e2.java <directory_path>");
            System.exit(1);
        }

//        Extract arguments into a string to transfer to method
        String directoryPath = args[0];

//        Execute DirectoryReader() method.
        DirectoryReaderAuxiliary.DirectoryReader(directoryPath);
//        Code used for testing purposes, commented so it doesn't affect the corrrect working of the program
//        DirectoryReaderAuxiliary.DirectoryReader("C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T5\\n1\\exercise2\\src\\files");
    }
}
