package br.univille.microservcursodeextensao.enroll;

import br.univille.microservcursodeextensao.api.ExceptionResponse;
import br.univille.microservcursodeextensao.enroll.exception.EnrollmentNotFoundException;
import br.univille.microservcursodeextensao.enroll.exception.InvalidEnrollmentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EnrollmentExceptionHandler {

    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEnrollmentNotFoundException(EnrollmentNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(InvalidEnrollmentException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidEnrollmentException(InvalidEnrollmentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(exception.getMessage()));
    }

}
