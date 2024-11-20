package br.univille.microservcursodeextensao.enroll.impl;

import br.univille.microservcursodeextensao.enroll.Enrollment;
import br.univille.microservcursodeextensao.enroll.EnrollmentRepository;
import br.univille.microservcursodeextensao.enroll.EnrollmentService;
import br.univille.microservcursodeextensao.enroll.exception.EnrollmentNotFoundException;
import br.univille.microservcursodeextensao.enroll.exception.InvalidEnrollmentException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            throw new InvalidEnrollmentException("Enrollment cannot be null");
        }

        if (enrollment.getId() != null) {
            throw new InvalidEnrollmentException("Enrollment ID must be null to create a new enrollment");
        }

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment getEnrollment(String id) {
        if (id == null) {
            throw new InvalidEnrollmentException("Enrollment ID cannot be null");
        }

        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found: " + id));
    }

    @Override
    public Enrollment updateEnrollment(String id, Enrollment enrollment) {
        if (enrollment == null) {
            throw new InvalidEnrollmentException("Enrollment cannot be null");
        }

        val existingEnrollment = getEnrollment(id);

        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        existingEnrollment.setEnrollmentStatus(enrollment.getEnrollmentStatus());
        existingEnrollment.setCertificate(enrollment.getCertificate());
        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment deleteEnrollment(String id) {
        Enrollment enrollment = getEnrollment(id);
        enrollmentRepository.deleteById(id);
        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return Lists.newArrayList(enrollmentRepository.findAll());
    }

}
