package br.univille.microservcursodeextensao.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import br.univille.microservcursodeextensao.course.valueobject.CourseName;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Certificate {

    private UUID id;

    private UUID student;

    private int hours;

    private CourseName courseName;

}
