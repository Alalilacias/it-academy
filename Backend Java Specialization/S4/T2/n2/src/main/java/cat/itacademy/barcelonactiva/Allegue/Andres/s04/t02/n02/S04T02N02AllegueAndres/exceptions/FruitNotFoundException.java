package cat.itacademy.barcelonactiva.Allegue.Andres.s04.t02.n02.S04T02N02AllegueAndres.exceptions;

public class FruitNotFoundException extends RuntimeException {

    public FruitNotFoundException(String message) {
        super(message);
    }

    public FruitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}