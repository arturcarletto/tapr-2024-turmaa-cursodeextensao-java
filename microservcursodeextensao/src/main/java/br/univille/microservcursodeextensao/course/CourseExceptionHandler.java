package br.univille.microservcursodeextensao.course;

import br.univille.microservcursodeextensao.api.ExceptionResponse;
import br.univille.microservcursodeextensao.course.exception.CourseNotFoundException;
import br.univille.microservcursodeextensao.course.exception.InvalidCourseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCourseNotFoundException(CourseNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(InvalidCourseException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidCourseException(InvalidCourseException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(exception.getMessage()));
    }

}
