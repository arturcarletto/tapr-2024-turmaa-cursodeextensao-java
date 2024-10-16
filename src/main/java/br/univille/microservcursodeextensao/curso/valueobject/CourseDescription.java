package br.univille.microservcursodeextensao.curso.valueobject;

import lombok.Data;

@Data
public class CourseDescription {

    private final String description;

    public CourseDescription(String description) {
        this.description = description;
    }

}
