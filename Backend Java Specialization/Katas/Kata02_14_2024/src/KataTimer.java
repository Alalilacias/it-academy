package Katas.Kata02_14_2024.src;
import java.util.concurrent.TimeUnit;

public class KataTimer {
    @SuppressWarnings("SameParameterValue")
    protected static void timerMethod(int counts, int delay) {
        while(counts > 0 && delay > 0) {
            System.out.println("There are " + counts-- + " counts left");
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(delay));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (counts == 0 && delay > 0) {
            System.out.println("Counter finished.");
        }

    }
}
