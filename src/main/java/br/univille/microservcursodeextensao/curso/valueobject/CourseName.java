package br.univille.microservcursodeextensao.curso.valueobject;

import lombok.Data;

@Data
public class CourseName {

    private final String name;

    public CourseName(String name) {
        this.name = name;
    }

}
