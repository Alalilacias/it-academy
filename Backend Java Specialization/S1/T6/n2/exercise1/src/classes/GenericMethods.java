package S1.T6.n2.exercise1.src.classes;

import java.util.stream.Stream;

public class GenericMethods {
    public static <T,U>void genericMethod(Person person, T t, U u) {
        Stream.of(
                        t,
                        u,
                        person
                ).map(Object::toString)
                .forEach(System.out::println);
    }
}
