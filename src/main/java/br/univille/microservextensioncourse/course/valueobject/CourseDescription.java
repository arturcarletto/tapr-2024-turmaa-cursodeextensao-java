package br.univille.microservextensioncourse.course.valueobject;

import lombok.Data;

@Data
public class CourseDescription {

    private final String description;

    public CourseDescription(String description) {
        this.description = description;
    }

}
