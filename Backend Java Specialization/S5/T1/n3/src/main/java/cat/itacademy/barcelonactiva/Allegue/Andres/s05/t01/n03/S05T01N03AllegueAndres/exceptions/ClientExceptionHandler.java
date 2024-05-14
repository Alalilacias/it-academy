package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n03.S05T01N03AllegueAndres.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> addExceptionHandler(WebClientResponseException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
