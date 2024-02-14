package S1.T8.n1.exercise5.src.classes;

public class Helper {
    protected static void testExercise(){
        PiProvider piProvider = () -> 3.14;

        System.out.println(piProvider.getPi());
    }
}
