package br.univille.microservcursodeextensao.curso;


import br.univille.microservcursodeextensao.curso.valueobject.Workload;
import br.univille.microservcursodeextensao.curso.valueobject.Syllabus;
import br.univille.microservcursodeextensao.curso.valueobject.SubjectName;
import br.univille.microservcursodeextensao.curso.valueobject.HourlyRate;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Subject {

    private final SubjectName nome;

    private final UUID professor;

    private final Syllabus syllabus;

    private final Workload horas;

    private final HourlyRate valor;

    private final List<ZonedDateTime> dias;

    private final LocalTime inicio;

    private final LocalTime fim;

    public Subject(SubjectName nome, UUID professor, Syllabus syllabus, Workload horas, HourlyRate valor, List<ZonedDateTime> dias, LocalTime inicio, LocalTime fim) {
        this.nome = nome;
        this.professor = professor;
        this.syllabus = syllabus;
        this.horas = horas;
        this.valor = valor;
        this.dias = dias;
        this.inicio = inicio;
        this.fim = fim;
    }


}
