package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom.NullCountryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@SuppressWarnings("unused")
public class BranchExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NullCountryException.class)
    public ResponseEntity<String> nullCountryExceptionHandler(NullCountryException nullCountryException){
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body("""
                        There is coffee all over the world.\

                        Increasingly, in a world in which computing is ubiquitous, the computists want to make coffee.\

                        Coffee brewing is an art, but the distributed intelligence of the web-connected world transcends art.\

                        Thus, there is a strong, dark, rich requirement for a protocol designed expressly for the brewing of coffee.\

                        Coffee is brewed using coffee pots.\

                        Any attempt to brew coffee with a teapot will result in this error code\s""");
    }
}
