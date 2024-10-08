package matricula;

import matricula.valueobject.StatusMatricula;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Matricula {

    private final UUID id;

    private final UUID aluno;

    private final UUID curso;

    private final StatusMatricula statusMatricula;

    private final ZonedDateTime dataMatricula;

    private final UUID certificado;

    public Matricula(UUID id, UUID aluno, UUID curso, StatusMatricula statusMatricula, ZonedDateTime dataMatricula, UUID certificado) {
        this.id = id;
        this.aluno = aluno;
        this.curso = curso;
        this.statusMatricula = statusMatricula;
        this.dataMatricula = dataMatricula;
        this.certificado = certificado;
    }
}
