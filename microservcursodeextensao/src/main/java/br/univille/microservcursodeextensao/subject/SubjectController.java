package br.univille.microservcursodeextensao.subject;

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
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable String id) {
        return ResponseEntity.ok(subjectService.getSubject(id));
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.createSubject(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String id, @Valid @RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.updateSubject(id, subject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable String id) {
        return ResponseEntity.ok(subjectService.deleteSubject(id));
    }

    @Topic(name = "${app.component.topic.subject}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Subject> updateEnrollment(@RequestBody(required = false) CloudEvent<Subject> cloudEvent) {
        val subject = cloudEvent.getData();
        return ResponseEntity.ok(subjectService.updateSubject(subject));
    }

}
