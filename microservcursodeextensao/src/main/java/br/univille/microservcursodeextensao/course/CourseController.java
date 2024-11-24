package br.univille.microservcursodeextensao.course;

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
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable String id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @Valid @RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable String id) {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

    @Topic(name = "${app.component.topic.course}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Course> updateCourse(@RequestBody(required = false) CloudEvent<Course> cloudEvent) {
        val course = cloudEvent.getData();
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

}
