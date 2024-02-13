package S1.T6.n2.exercise1.src.classes;

public abstract class Helper extends GenericMethods {
    public static void testExercise(){
//        Method tested with different input orders and number of input Objects. Upon testing, the failsafe for incorrect input is shown
        genericMethod(new Person("Pedro", "Pascal", 30), "is a", 10);
        genericMethod(new Person("I'm not a", "Fan of", 99), "On the other hand, Taylor Swift");
    }
}
