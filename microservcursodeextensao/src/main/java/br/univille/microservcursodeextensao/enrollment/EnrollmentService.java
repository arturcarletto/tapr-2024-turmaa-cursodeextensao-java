package br.univille.microservcursodeextensao.enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment createEnrollment(Enrollment enrollment);

    Enrollment getEnrollment(String id);

    Enrollment updateEnrollment(String id, Enrollment enrollment);

    Enrollment updateEnrollment(Enrollment enrollment);

    Enrollment deleteEnrollment(String id);

    List<Enrollment> getAllEnrollments();

}
