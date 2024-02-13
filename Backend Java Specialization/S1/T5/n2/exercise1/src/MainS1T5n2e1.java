package S1.T5.n2.exercise1.src;

import S1.T5.n2.exercise1.src.exercise3src_copy.classes.DirectoryReaderAuxiliary;

import java.util.Properties;

public class MainS1T5n2e1 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("To use this file, the correct command is as follows: java MainS1T4n1e3.java <config_file_path>");
            System.exit(1);
        }
        Properties config = DirectoryReaderAuxiliary.configLoad("config.properties");

        DirectoryReaderAuxiliary.DirectoryReader(config.getProperty("directoryPath"), config.getProperty("outputPath"));
    }
}