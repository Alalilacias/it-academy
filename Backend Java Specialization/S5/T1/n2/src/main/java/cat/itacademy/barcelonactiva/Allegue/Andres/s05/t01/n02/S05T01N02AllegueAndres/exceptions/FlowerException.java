package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions;

public class FlowerException extends RuntimeException {
    public FlowerException(String cause, String information){
        super("Method Responsible: " + cause + "\nExtra Information: " + information);
    }
}
