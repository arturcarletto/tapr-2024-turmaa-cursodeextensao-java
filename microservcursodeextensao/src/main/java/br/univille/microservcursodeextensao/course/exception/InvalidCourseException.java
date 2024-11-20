package br.univille.microservcursodeextensao.course.exception;

public class InvalidCourseException extends RuntimeException {

    public InvalidCourseException(String message) {
        super(message);
    }
}
