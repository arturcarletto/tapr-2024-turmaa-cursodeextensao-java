package br.univille.microservcursodeextensao.subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject(Subject subject);

    Subject getSubject(String id);

    Subject updateSubject(String id, Subject subject);

    Subject updateSubject(Subject subject);

    Subject deleteSubject(String id);

    List<Subject> getAllSubjects();

}
