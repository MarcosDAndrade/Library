package br.project.Library.infra;

import br.project.Library.Exception.NotNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotNullException.class)
    private ResponseEntity<String> NotNullException(NotNullException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Field cannot be null");
    }
}
