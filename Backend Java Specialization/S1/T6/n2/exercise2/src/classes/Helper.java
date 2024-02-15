package S1.T6.n2.exercise2.src.classes;

import java.util.Arrays;

public abstract class Helper extends GenericMethods {
    public static void testExercise(){
//        Method tested with different input orders and number of input Objects. Upon testing, the failsafe for incorrect input is shown
        genericMethod(Arrays.asList(new Person("Pedro", "Pascal", 30), "is a", 10));
        genericMethod(Arrays.asList("On the other hand, Taylor Swift", new Person("I'm not a", "Fan of", 99)));
    }
}
