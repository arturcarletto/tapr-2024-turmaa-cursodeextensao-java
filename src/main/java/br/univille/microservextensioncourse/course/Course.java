package br.univille.microservextensioncourse.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import br.univille.microservextensioncourse.course.valueobject.CourseDescription;
import br.univille.microservextensioncourse.course.valueobject.CourseName;

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
