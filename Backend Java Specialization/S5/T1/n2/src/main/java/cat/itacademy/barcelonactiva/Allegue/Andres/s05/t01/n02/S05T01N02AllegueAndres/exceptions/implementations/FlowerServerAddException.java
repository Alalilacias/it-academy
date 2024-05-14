package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations;

public class FlowerServerAddException extends RuntimeException {
    public FlowerServerAddException(String message, Throwable cause){
        super(message, cause, false, false);
    }
}
