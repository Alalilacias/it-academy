package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.exceptions.implementations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(FlowerServerAddException.class)
    public ResponseEntity<String> addExceptionHandler(FlowerServerAddException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(FlowerServerGetOneException.class)
    public ResponseEntity<String> addExceptionHandler(FlowerServerGetOneException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(FlowerServerGetAllException.class)
    public ResponseEntity<String> addExceptionHandler(FlowerServerGetAllException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(FlowerServerUpdateException.class)
    public ResponseEntity<String> addExceptionHandler(FlowerServerUpdateException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(FlowerServerDeleteException.class)
    public ResponseEntity<String> addExceptionHandler(FlowerServerDeleteException e){
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}