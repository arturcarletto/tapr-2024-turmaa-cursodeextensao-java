package br.univille.microservcursodeextensao.curso;

import br.univille.microservcursodeextensao.curso.valueobject.CourseDescription;
import br.univille.microservcursodeextensao.curso.valueobject.CourseName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {

    private UUID id;

    private CourseName courseName;

    private CourseDescription courseDescription;

    private List<UUID> enrolledStudents;

    private List<Subject> subjects;

    private List<ReservedClassroom> reservedClassrooms;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

}
