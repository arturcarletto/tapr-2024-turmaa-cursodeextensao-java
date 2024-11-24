package br.univille.microservcursodeextensao.course.impl;

import br.univille.microservcursodeextensao.course.Course;
import br.univille.microservcursodeextensao.course.CourseRepository;
import br.univille.microservcursodeextensao.course.CourseService;
import br.univille.microservcursodeextensao.course.exception.CourseNotFoundException;
import br.univille.microservcursodeextensao.course.exception.InvalidCourseException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final String topicName;

    private final String pubSubName;

    private final DaprClient daprClient;

    public CourseServiceImpl(
            CourseRepository courseRepository,
            @Value("${app.component.topic.enrollment}") String topicName,
            @Value("${app.component.service}") String pubSubName
    ) {
        this.courseRepository = courseRepository;
        this.topicName = topicName;
        this.pubSubName = pubSubName;
        this.daprClient = new DaprClientBuilder().build();
    }

    @Override
    public Course createCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null");
        }

        if (course.getId() != null) {
            throw new InvalidCourseException("Course ID must be null to create a new course");
        }

        val savedCourse = courseRepository.save(course);
        publishCourseUpdate(savedCourse);
        return savedCourse;
    }

    @Override
    public Course getCourse(String id) {
        if (id == null) {
            throw new InvalidCourseException("Course ID cannot be null");
        }

        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found: " + id));
    }

    @Override
    public Course updateCourse(String id, Course course) {
        var existingCourse = getCourse(id);

        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseDescription(course.getCourseDescription());
        existingCourse.setEnrolledStudents(course.getEnrolledStudents());
        existingCourse.setSubjects(course.getSubjects());
        existingCourse.setReservedClassrooms(course.getReservedClassrooms());
        existingCourse.setStartDate(course.getStartDate());
        existingCourse.setEndDate(course.getEndDate());

        val savedCourse = courseRepository.save(course);
        publishCourseUpdate(savedCourse);
        return savedCourse;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course deleteCourse(String id) {
        var course = getCourse(id);
        courseRepository.deleteById(id);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    private void publishCourseUpdate(Course course) {
        daprClient
                .publishEvent(pubSubName, topicName, course)
                .block(Duration.ofSeconds(10));
    }

}
