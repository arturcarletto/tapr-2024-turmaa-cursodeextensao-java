package br.univille.microservcursodeextensao.course.valueobject;

import lombok.Data;

@Data
public class Syllabus {

    private String syllabus;

    public Syllabus(String syllabus) {
        this.syllabus = syllabus;
    }

}
