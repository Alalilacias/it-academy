package S1.T8.n1.exercise8.src.classes;

public class Helper {
    protected static void testExercise(){
        Limitless cursedTechnique = input -> new StringBuilder(input).reverse().toString();

        System.out.println(cursedTechnique.reverse("eulB"));
    }
}
