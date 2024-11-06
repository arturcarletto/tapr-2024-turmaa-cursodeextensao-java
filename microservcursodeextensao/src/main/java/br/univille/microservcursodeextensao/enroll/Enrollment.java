package br.univille.microservcursodeextensao.enroll;

import java.time.ZonedDateTime;
import java.util.UUID;

import br.univille.microservcursodeextensao.enroll.valueobject.EnrollmentStatus;

public class Enrollment {

    private UUID id;

    private UUID student;

    private UUID course;

    private EnrollmentStatus enrollmentStatus;

    private ZonedDateTime enrollmentDate;

    private UUID certificate;

}
