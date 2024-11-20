package br.univille.microservcursodeextensao.subject;

import br.univille.microservcursodeextensao.api.ExceptionResponse;
import br.univille.microservcursodeextensao.subject.exception.InvalidSubjectException;
import br.univille.microservcursodeextensao.subject.exception.SubjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SubjectExceptionHandler {

    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleSubjectNotFoundException(SubjectNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(InvalidSubjectException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidSubjectException(InvalidSubjectException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(exception.getMessage()));
    }

}
