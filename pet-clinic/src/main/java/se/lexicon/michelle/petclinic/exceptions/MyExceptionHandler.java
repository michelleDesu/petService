package se.lexicon.michelle.petclinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MyExceptionResponse> handleIllegalException(IllegalArgumentException ex, WebRequest request){
            MyExceptionResponse myExceptionResponse = new MyExceptionResponse(
             LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    HttpStatus.BAD_REQUEST.name(),
                    ex.getMessage(),
                    request.getDescription(false)
            );

            return ResponseEntity.badRequest().body(myExceptionResponse);
    }

    @ExceptionHandler(RecourseNotFoundException.class)
    public ResponseEntity<MyExceptionResponse> handleRecourseNotFoundException(RecourseNotFoundException ex, WebRequest request){
        MyExceptionResponse myExceptionResponse = new MyExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(myExceptionResponse);
    }
}
