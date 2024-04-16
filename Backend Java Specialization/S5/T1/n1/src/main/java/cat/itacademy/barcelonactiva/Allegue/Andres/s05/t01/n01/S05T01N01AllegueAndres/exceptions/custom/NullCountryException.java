package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception indicating that the country value is null. Filled in its entirety as I was trying to deepen my own understanding of the exceptions.
 * It's contents are mostly useless.
 */
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
@SuppressWarnings("unused")
public class NullCountryException extends IllegalArgumentException {

    public NullCountryException() {
        super("Country cannot be null");
    }

    public NullCountryException(String message) {
        super(message);
    }

    public NullCountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullCountryException(Throwable cause) {
        super("Country cannot be null", cause);
    }
}