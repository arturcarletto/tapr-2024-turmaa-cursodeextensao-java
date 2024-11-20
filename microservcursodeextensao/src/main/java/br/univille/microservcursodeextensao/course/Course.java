package br.univille.microservcursodeextensao.course;

import br.univille.microservcursodeextensao.course.valueobject.CourseDescription;
import br.univille.microservcursodeextensao.course.valueobject.CourseName;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Container(containerName = "course", autoCreateContainer = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;

    private CourseName courseName;

    private CourseDescription courseDescription;

    private List<String> enrolledStudents;

    private List<String> subjects;

    private List<String> reservedClassrooms;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

}
