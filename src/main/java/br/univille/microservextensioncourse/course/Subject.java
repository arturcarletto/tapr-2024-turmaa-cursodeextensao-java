package br.univille.microservextensioncourse.course;


import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import br.univille.microservextensioncourse.course.valueobject.HourlyRate;
import br.univille.microservextensioncourse.course.valueobject.SubjectName;
import br.univille.microservextensioncourse.course.valueobject.Syllabus;
import br.univille.microservextensioncourse.course.valueobject.Workload;

public class Subject {

    private final SubjectName name;

    private final UUID professor;

    private final Syllabus syllabus;

    private final Workload hour;

    private final HourlyRate value;

    private final List<ZonedDateTime> days;

    private final LocalTime start;

    private final LocalTime end;

    public Subject(SubjectName name, UUID professor, Syllabus syllabus, Workload hour, HourlyRate value, List<ZonedDateTime> days, LocalTime start, LocalTime end) {
        this.name = name;
        this.professor = professor;
        this.syllabus = syllabus;
        this.hour = hour;
        this.value = value;
        this.days = days;
        this.start = start;
        this.end = end;
    }


}