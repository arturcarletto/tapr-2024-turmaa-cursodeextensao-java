package br.univille.microservcursodeextensao.course.impl;

import br.univille.microservcursodeextensao.course.Course;
import br.univille.microservcursodeextensao.course.CourseRepository;
import br.univille.microservcursodeextensao.course.CourseService;
import br.univille.microservcursodeextensao.course.exception.CourseNotFoundException;
import br.univille.microservcursodeextensao.course.exception.InvalidCourseException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        if (course == null) {
            throw new InvalidCourseException("Course cannot be null");
        }

        if (course.getId() != null) {
            throw new InvalidCourseException("Course ID must be null to create a new course");
        }

        return courseRepository.save(course);
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

        return courseRepository.save(course);
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

}
