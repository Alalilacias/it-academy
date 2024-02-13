package S1.T7.n1.exercise1.src.classes;

public class Helper {

    protected static void testExercise(){
//        Instantiation of one onSiteWorker and one OnlineWorker
        OnSiteWorker pedro = new OnSiteWorker("Pedro", "Pascal", 25);
        OnlineWorkers taylor = new OnlineWorkers("Taylor", "Swift", 1);

//        Method invocation to demonstrate overriding's proper working. Without overriding the results would be 1000€ and 40€ respectively.
        System.out.println(pedro);
        System.out.println(taylor);
    }
}
