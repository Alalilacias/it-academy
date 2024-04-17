package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@SuppressWarnings("unused")
public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException() {
        super("Branch not found.");
    }

    public BranchNotFoundException(String message) {
        super(message);
    }

    public BranchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BranchNotFoundException(Throwable cause) {
        super("Branch not found.", cause);
    }
}
