package br.univille.microservcursodeextensao.course.valueobject;

import lombok.Data;

@Data
public class CourseDescription {

    private final String description;

    public CourseDescription(String description) {
        this.description = description;
    }

}
