package S1.T6.n2.exercise1.src.classes;

public class GenericMethods {
    public static void genericMethod(Person person, Object ... objects) {
        if(objects.length != 2){
            System.out.println("A person and two objects are required for this method.");
            return;
        }

        String consoleText = "The printed equivalent of the received objects is:" +
                "\n- " + person;

        for (Object object : objects) {
            consoleText = consoleText.concat("\n- " + object);
        }

        System.out.println(consoleText);
    }
}
