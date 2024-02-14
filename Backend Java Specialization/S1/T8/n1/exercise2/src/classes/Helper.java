package S1.T8.n1.exercise2.src.classes;

public class Helper {
    protected static void testExercise(){
        System.out.println(String.join("\n- ", StringListReader.StringListReaderMethod()));
    }

    /*
        Original code, reduced with the help of some very nice Stack Overflow fellows.

        String textToPrint = "The names that contain the letter 'o' are:";

        for (String nameWithO : StringListReader.StringListReaderMethod()){
            textToPrint = textToPrint.concat("\n- " + nameWithO);
        }

        System.out.println(textToPrint);
*/
}
