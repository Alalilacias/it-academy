package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.exceptions.custom.NullBranchTypeException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@SuppressWarnings("unused")
public class BranchExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException){
        logger.debug("Error message:" + illegalArgumentException.getMessage()
        + "\nError cause: " + illegalArgumentException.getCause());
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body("""
                        There is coffee all over the world.\

                        Increasingly, in a world in which computing is ubiquitous, the computists want to make coffee.\

                        Coffee brewing is an art, but the distributed intelligence of the web-connected world transcends art.\

                        Thus, there is a strong, dark, rich requirement for a protocol designed expressly for the brewing of coffee.\

                        Coffee is brewed using coffee pots.\

                        Any attempt to brew coffee with a teapot will result in this error code\s""");
    }

    @ExceptionHandler(NullBranchTypeException.class)
    public ResponseEntity<String> nullBranchTypeExceptionHandler(NullBranchTypeException branchTypeException){
        logger.error("Error message: " + branchTypeException.getMessage()
        + "\nError cause: " + branchTypeException.getCause()
        + "\nBranch type: " + branchTypeException.getType().name());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("An error occurred when processing your request, please contact our support team.");
    }
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> serviceExceptionHandler(ServiceException serviceException){
        logger.error("Error message: " + serviceException.getMessage()
        + "\nError cause: " + serviceException.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred when processing your request, please contact our support team.");
    }
}
