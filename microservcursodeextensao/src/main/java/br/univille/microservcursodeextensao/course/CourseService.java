package br.univille.microservcursodeextensao.course;


import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    Course getCourse(String id);

    Course updateCourse(String id, Course course);

    Course updateCourse(Course course);

    Course deleteCourse(String id);

    List<Course> getAllCourses();

}
