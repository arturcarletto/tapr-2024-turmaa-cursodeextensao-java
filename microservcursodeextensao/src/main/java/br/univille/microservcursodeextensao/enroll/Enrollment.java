package br.univille.microservcursodeextensao.enroll;

import java.time.ZonedDateTime;
import java.util.UUID;

import br.univille.microservcursodeextensao.enroll.valueobject.EnrollmentStatus;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

@Container(containerName = "enrollment", autoCreateContainer = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;

    private UUID student;

    private UUID course;

    private EnrollmentStatus enrollmentStatus;

    private ZonedDateTime enrollmentDate;

    private UUID certificate;

}
