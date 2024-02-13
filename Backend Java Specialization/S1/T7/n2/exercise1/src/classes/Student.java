package S1.T7.n2.exercise1.src.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

@JsonSerializer(directory = "C:\\Users\\alleg\\IdeaProjects\\it-academy\\Backend Java Specialization\\S1\\T7\\n2\\exercise1\\src\\files")
public class Student {
    protected final String name;
    protected final int currentSprint;

    public Student(String name, int currentSprint){
        this.name = name;
        this.currentSprint = currentSprint;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void JsonSerializer() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File outputDirectory = new File(getDirectory());


        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        File outputFile = new File(outputDirectory, "Student.json");
        objectMapper.writeValue(outputFile, this);
    }

    public static String getDirectory(){

        JsonSerializer annotation = Student.class.getAnnotation(JsonSerializer.class);

        return (annotation != null) ? annotation.directory() : "";
    }
}
