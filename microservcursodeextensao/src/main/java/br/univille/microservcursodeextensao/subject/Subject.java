package br.univille.microservcursodeextensao.subject;


import br.univille.microservcursodeextensao.subject.valueobject.HourlyRate;
import br.univille.microservcursodeextensao.subject.valueobject.SubjectName;
import br.univille.microservcursodeextensao.subject.valueobject.Syllabus;
import br.univille.microservcursodeextensao.subject.valueobject.Workload;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

@Container(containerName = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;

    private SubjectName name;

    private String professor;

    private Syllabus syllabus;

    private Workload hour;

    private HourlyRate value;

    private List<ZonedDateTime> days;

    private LocalTime start;

    private LocalTime end;


}
