package br.univille.microservcursodeextensao.enrollment;

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable String id) {
        return ResponseEntity.ok(enrollmentService.getEnrollment(id));
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable String id, @Valid @RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Enrollment> deleteEnrollment(@PathVariable String id) {
        return ResponseEntity.ok(enrollmentService.deleteEnrollment(id));
    }

    @Topic(name = "${app.component.topic.enrollment}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Enrollment> updateEnrollment(@RequestBody(required = false) CloudEvent<Enrollment> cloudEvent) {
        val enrollment = cloudEvent.getData();
        return ResponseEntity.ok(enrollmentService.updateEnrollment(enrollment));
    }

}
