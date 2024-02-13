package S1.T7.n2.exercise1.src.classes;

import java.io.IOException;

public class Helper {

    protected static void testExercise(){
        try {
            Student me = new Student("Pere", 1);
            me.JsonSerializer();
            System.out.println("Your student class has been serialized to JSON.");
        }   catch (IOException e) {
            System.out.println("IOException, JsonGenerationException or JsonMappingException. Check the code.");
        }
    }
}
