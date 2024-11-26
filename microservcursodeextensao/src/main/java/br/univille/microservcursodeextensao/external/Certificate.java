package br.univille.microservcursodeextensao.external;

import br.univille.microservcursodeextensao.course.valueobject.CourseName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Certificate {

    private String id;

    private String student;

    private int hours;

    private CourseName courseName;

}
