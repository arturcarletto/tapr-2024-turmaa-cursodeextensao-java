package br.univille.microservcursodeextensao.enrollment.impl;

import br.univille.microservcursodeextensao.enrollment.Enrollment;
import br.univille.microservcursodeextensao.enrollment.EnrollmentRepository;
import br.univille.microservcursodeextensao.enrollment.EnrollmentService;
import br.univille.microservcursodeextensao.enrollment.exception.EnrollmentNotFoundException;
import br.univille.microservcursodeextensao.enrollment.exception.InvalidEnrollmentException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final String topicName;

    private final String pubSubName;

    private final DaprClient daprClient;

    public EnrollmentServiceImpl(
            EnrollmentRepository enrollmentRepository,
            @Value("${app.component.topic.enrollment}") String topicName,
            @Value("${app.component.service}") String pubSubName
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.topicName = topicName;
        this.pubSubName = pubSubName;
        this.daprClient = new DaprClientBuilder().build();
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        if (enrollment == null) {
            throw new InvalidEnrollmentException("Enrollment cannot be null");
        }

        if (enrollment.getId() != null) {
            throw new InvalidEnrollmentException("Enrollment ID must be null to create a new enrollment");
        }

        val savedEnrollment = enrollmentRepository.save(enrollment);
        publishEnrollmentUpdate(savedEnrollment);
        return savedEnrollment;
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

        val savedEnrollment = enrollmentRepository.save(enrollment);
        publishEnrollmentUpdate(savedEnrollment);
        return savedEnrollment;
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

    private void publishEnrollmentUpdate(Enrollment enrollment) {
        daprClient
                .publishEvent(pubSubName, topicName, enrollment)
                .block(Duration.ofSeconds(10));
    }

}
