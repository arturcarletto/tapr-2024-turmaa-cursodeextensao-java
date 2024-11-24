package br.univille.microservcursodeextensao.subject.impl;

import br.univille.microservcursodeextensao.subject.Subject;
import br.univille.microservcursodeextensao.subject.SubjectRepository;
import br.univille.microservcursodeextensao.subject.SubjectService;
import br.univille.microservcursodeextensao.subject.exception.InvalidSubjectException;
import br.univille.microservcursodeextensao.subject.exception.SubjectNotFoundException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final String topicName;

    private final String pubSubName;

    private final DaprClient daprClient;

    public SubjectServiceImpl(
            SubjectRepository subjectRepository,
            @Value("${app.component.topic.subject}") String topicName,
            @Value("${app.component.service}") String pubSubName
    ) {
        this.subjectRepository = subjectRepository;
        this.topicName = topicName;
        this.pubSubName = pubSubName;

        this.daprClient = new DaprClientBuilder().build();
    }

    @Override
    public Subject createSubject(Subject subject) {
        if (subject == null) {
            throw new InvalidSubjectException("Subject cannot be null");
        }

        if (subject.getId() != null) {
            throw new InvalidSubjectException("Subject ID must be null to create a new subject");
        }

        val savedSubject = subjectRepository.save(subject);
        publishSubjectUpdate(savedSubject);
        return savedSubject;
    }

    @Override
    public Subject getSubject(String id) {
        if (id == null) {
            throw new InvalidSubjectException("Subject ID cannot be null");
        }

        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException("Subject not found: " + id));
    }

    @Override
    public Subject updateSubject(String id, Subject subject) {
        val existingSubject = getSubject(id);

        existingSubject.setName(subject.getName());
        existingSubject.setProfessor(subject.getProfessor());
        existingSubject.setSyllabus(subject.getSyllabus());
        existingSubject.setHour(subject.getHour());
        existingSubject.setValue(subject.getValue());
        existingSubject.setDays(subject.getDays());
        existingSubject.setStart(subject.getStart());
        existingSubject.setEnd(subject.getEnd());

        val savedSubject = subjectRepository.save(subject);
        publishSubjectUpdate(savedSubject);

        return savedSubject;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject deleteSubject(String id) {
        val existingSubject = getSubject(id);
        subjectRepository.delete(existingSubject);
        return existingSubject;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return Lists.newArrayList(subjectRepository.findAll());
    }

    private void publishSubjectUpdate(Subject subject) {
        daprClient
                .publishEvent(pubSubName, topicName, subject)
                .block(Duration.ofSeconds(10));
    }

}
