package S1.T5.n1.exercise3.src;

import S1.T5.n1.exercise3.src.classes.DirectoryReaderAuxiliary;

public class MainS1T4n1e3 {
    public static void main(String[] args) {
//        Check that there's two arguments, arguably the paths. Remind user of instructions if not.
        if (args.length != 2) {
            System.out.println("To use this file, the correct command is as follows: java MainS1T4n1e3.java <directory_path> <output_path>");
            System.exit(1);
        }

//        Extract command line arguments
        String directoryPath = args[0];
        String savePath = args[1];

//        Execute DirectoryReader() method.
        DirectoryReaderAuxiliary.DirectoryReader(directoryPath, savePath);

//        Code used for testing purposes, commented so it doesn't affect the corrrect working of the program
//        DirectoryReaderAuxiliary2.DirectoryReader("files", "saveFile.txt");
    }
}
