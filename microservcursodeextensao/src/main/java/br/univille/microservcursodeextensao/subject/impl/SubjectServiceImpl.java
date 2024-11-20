package br.univille.microservcursodeextensao.subject.impl;

import br.univille.microservcursodeextensao.subject.Subject;
import br.univille.microservcursodeextensao.subject.SubjectRepository;
import br.univille.microservcursodeextensao.subject.SubjectService;
import br.univille.microservcursodeextensao.subject.exception.InvalidSubjectException;
import br.univille.microservcursodeextensao.subject.exception.SubjectNotFoundException;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        if (subject == null) {
            throw new InvalidSubjectException("Subject cannot be null");
        }

        if (subject.getId() != null) {
            throw new InvalidSubjectException("Subject ID must be null to create a new subject");
        }

        return subjectRepository.save(subject);
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

        return subjectRepository.save(subject);
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

}
