package br.univille.microservcursodeextensao.external;

import br.univille.microservcursodeextensao.curso.valueobject.CourseName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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
