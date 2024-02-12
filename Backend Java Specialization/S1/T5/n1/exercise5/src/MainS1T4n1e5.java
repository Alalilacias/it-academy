package S1.T5.n1.exercise5.src;

import S1.T5.n1.exercise5.src.classes.DirectoryReaderAuxiliary;
import S1.T5.n1.exercise5.src.classes.E5Object;

public class MainS1T4n1e5 {
    public static void main(String[] args) {
        if (args[0].equalsIgnoreCase("serialize")){
            E5Object object = new E5Object(args[1]);
            DirectoryReaderAuxiliary.serialize(object, args[2]);
        } else if (args[0].equalsIgnoreCase("deserialize")) {
            DirectoryReaderAuxiliary.deserialize(args[1]);
        } else if (args.length == 2) {
            String directoryPath = args[0];
            String savePath = args[1];
            DirectoryReaderAuxiliary.DirectoryReader(directoryPath, savePath);
        } else if (args.length == 1) {
            String filePath = args[0];
            DirectoryReaderAuxiliary.readTextFile(filePath);
        } else {
            System.out.println("To use this program, the correct command must follow the next structure:\n" +
                    "- java MainS1T4n1e4.java <directory_path> <output_path>\n" +
                    "- java MainS1T4n1e3.java <file_path>\n" +
                    "- java MainS1T4n1e5.java serialize <directory_path> <serialization_path>\n" +
                    "- java MainS1T4n1e5.java deserialize <deserialization_path>");
        }
    }
}
