package br.univille.microservcursodeextensao.curso.valueobject;

import lombok.Data;

@Data
public class SubjectName {

    private final String name;

    public SubjectName(String name) {
        this.name = name;
    }


}
