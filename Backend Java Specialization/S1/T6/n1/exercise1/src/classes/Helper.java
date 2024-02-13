package S1.T6.n1.exercise1.src.classes;

public class Helper {
    public static void testExercise(){
//        Instantiation of the generic class with the same objects in a different order to check that arguments
//        can be placed anywhere in the constructor call.
        NoGenericMethods textInstance = new NoGenericMethods("5", "15", "45");
        NoGenericMethods textInstanceII = new NoGenericMethods("45", "5", "15");

//        Retrieval of the objects and printing through console
        System.out.println(textInstance);
        System.out.println(textInstanceII);

//        While not requested by the exercise, test that shows that a different type of object cannot be input. Uncomment to test.
//        textInstanceII.setObjectIII(85);
    }
}
