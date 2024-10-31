package br.univille.microservextensioncourse.course.valueobject;

import lombok.Data;

@Data
public class SubjectName {

    private final String name;

    public SubjectName(String name) {
        this.name = name;
    }


}
