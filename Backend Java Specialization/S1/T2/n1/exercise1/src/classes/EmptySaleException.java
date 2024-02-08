package S1.T2.n1.exercise1.src.classes;

public class EmptySaleException extends Exception {
    public EmptySaleException() {
        super("To make a sale you must first add products");
    }
}
