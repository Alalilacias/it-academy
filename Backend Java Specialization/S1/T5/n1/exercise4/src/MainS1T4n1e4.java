package S1.T5.n1.exercise4.src;

import S1.T5.n1.exercise4.src.classes.DirectoryReaderAuxiliary;

public class MainS1T4n1e4 {
    public static void main(String[] args) {
//        Check the length of the arguments array, to see what functionality the user wants to make use of.
        if (args.length == 2) {
            String directoryPath = args[0];
            String savePath = args[1];
            DirectoryReaderAuxiliary.DirectoryReader(directoryPath, savePath);
        }
        if (args.length == 1) {
            String filePath = args[0];
            DirectoryReaderAuxiliary.readTextFile(filePath);
        } else {
            System.out.println("To use this program, the correct command must follow the next structure:\n" +
                    "- java MainS1T4n1e4.java <directory_path> <output_path>\n" +
                    "- java MainS1T4n1e3.java <file_path>");
        }
    }
}
