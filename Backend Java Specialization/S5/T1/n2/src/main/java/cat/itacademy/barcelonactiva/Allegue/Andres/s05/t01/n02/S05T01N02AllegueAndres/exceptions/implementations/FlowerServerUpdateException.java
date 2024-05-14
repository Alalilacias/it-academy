package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations;

public class FlowerServerUpdateException extends RuntimeException {
    public FlowerServerUpdateException(String message){
        super(message, null, false, false);
    }
    public FlowerServerUpdateException(String message, Throwable cause){
        super(message, cause, false, false);
    }
}
