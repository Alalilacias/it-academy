package S1.T8.n2.exercise3.src.classes;

public class Helper {
    @SuppressWarnings("Convert2MethodRef")
    static Calculator add = (a, b) -> a + b;
    static Calculator substract = (a, b) -> a - b;
    static Calculator multiply = (a, b) -> a * b;
    static Calculator divide = (a, b) -> b != 0 ? a / b : Float.NaN;

    protected static void testExercise(){

        System.out.println("We'll perform all operations with the numbers 1 and 2:" +
                "\nAddition's result: " + add.operation(1, 2) +
                "\nSubtraction's result: " + substract.operation(1, 2) +
                "\nMultiplication's result: " + multiply.operation(1,2) +
                "\nDivision's result: " + divide.operation(1,2));
    }
}
