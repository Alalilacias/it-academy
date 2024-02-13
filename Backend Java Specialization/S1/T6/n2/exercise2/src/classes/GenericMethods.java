package S1.T6.n2.exercise2.src.classes;

public class GenericMethods {
    @SafeVarargs
    public static <T> void genericMethod(T... objects) {
        if(objects.length != 3){
            System.out.println("Three objects are required for this method.");
            return;
        }

        String consoleText = "The printed equivalent of the received objects is:";

        for (Object object : objects) {
            consoleText = consoleText.concat("\n- " + object);
        }

        System.out.println(consoleText);
    }
}
