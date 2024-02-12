package S1.T5.n1.exercise5.src.classes;

import java.io.*;
import java.util.Arrays;

public class E5Object implements Serializable {

    private final String directoryPath;
    private final File[] fileNames;

    public E5Object (String directoryPath){
        this.directoryPath = directoryPath;
        this.fileNames = new File(directoryPath).listFiles();
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
    public File[] getFileNames() {
        return this.fileNames;
    }

    @Override
    public String toString() {
        return "E5Object{" +
                "directoryPath='" + directoryPath + '\'' +
                ", fileNames=" + Arrays.toString(fileNames) +
                '}';
    }
}
