package br.univille.microservcursodeextensao.matricula;

import br.univille.microservcursodeextensao.matricula.valueobject.EnrollmentStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Enrollment {

    private UUID id;

    private UUID student;

    private UUID course;

    private EnrollmentStatus enrollmentStatus;

    private ZonedDateTime enrollmentDate;

    private UUID certificate;

}
