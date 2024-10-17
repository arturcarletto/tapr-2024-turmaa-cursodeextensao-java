package br.univille.microservcursodeextensao.curso.valueobject;

import lombok.Data;

@Data
public class Syllabus {

    private String syllabus;

    public Syllabus(String syllabus) {
        this.syllabus = syllabus;
    }

}
