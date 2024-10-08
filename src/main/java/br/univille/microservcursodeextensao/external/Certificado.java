package external;

import external.valueobject.CPF;

import java.util.UUID;

public class Certificado {

    private final UUID id;

    private final UUID idAluno;

    private final int horas;

    private final String noemCurso;

    public Certificado(UUID id, UUID idAluno, int horas, String noemCurso) {
        this.id = id;
        this.idAluno = idAluno;
        this.horas = horas;
        this.noemCurso = noemCurso;
    }

}
