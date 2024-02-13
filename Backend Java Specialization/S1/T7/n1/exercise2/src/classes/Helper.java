package S1.T7.n1.exercise2.src.classes;

public class Helper {

    @SuppressWarnings("deprecation")
    protected static void testExercise(){
//        Instantiation of one onSiteWorker and one OnlineWorker
        OnSiteWorker pedro = new OnSiteWorker("Pedro", "Pascal", 25);
        OnlineWorkers taylor = new OnlineWorkers("Taylor", "Swift", 1);

//        Method invocation to demonstrate override's proper functioning. Without overriding the results would be 1000€ and 40€ respectively.
        System.out.println(pedro);
        System.out.println(taylor);

//        Deprecated method invocation to demonstrate the suppressing method's proper functioning.
        System.out.println(pedro.excuseForDrinking());
        System.out.println(taylor.pleadingForMercy());
    }
}
