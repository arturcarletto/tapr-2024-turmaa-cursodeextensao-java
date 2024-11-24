package br.univille.microservcursodeextensao.enrollment;

import java.time.ZonedDateTime;

import br.univille.microservcursodeextensao.enrollment.valueobject.EnrollmentStatus;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

@Container(containerName = "enrollment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;

    private String student;

    private String course;

    private EnrollmentStatus enrollmentStatus;

    private ZonedDateTime enrollmentDate;

    private String certificate;

}
