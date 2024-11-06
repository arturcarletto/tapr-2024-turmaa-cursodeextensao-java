package br.univille.microservcursodeextensao.subject.valueobject;

import lombok.Data;

@Data
public class SubjectName {

    private final String name;

    public SubjectName(String name) {
        this.name = name;
    }


}
