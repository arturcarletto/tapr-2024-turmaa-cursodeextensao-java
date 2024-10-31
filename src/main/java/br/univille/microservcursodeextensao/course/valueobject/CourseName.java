package br.univille.microservcursodeextensao.course.valueobject;

import lombok.Data;

@Data
public class CourseName {

    private final String name;

    public CourseName(String name) {
        this.name = name;
    }

}
