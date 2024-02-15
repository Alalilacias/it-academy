package S1.T6.n2.exercise2.src.classes;

import java.util.List;

public class GenericMethods {
    public static void genericMethod(List<?> list) {
        list.stream().map(Object::toString)
                .forEach(System.out::println);
    }
}
