package S1.T6.n1.exercise2.src.classes;
import java.util.stream.Stream;

public class GenericMethods {
    public static <T,U,V> void genericMethod(T t, U u, V v) {
        Stream.of(
                t,
                u,
                v
        ).map(Object::toString)
                .forEach(System.out::println);
    }
}
