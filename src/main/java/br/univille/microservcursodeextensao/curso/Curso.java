package curso;

import curso.valueobject.DescricaoCurso;
import curso.valueobject.NomeCurso;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Curso {

    private final UUID id;

    private final NomeCurso nome;

    private final DescricaoCurso descricaoCurso;

    private final List<UUID> matriculas;

    private final List<Disciplina> disciplinas;

    private final List<SalaReservada> salaReservadas;

    private final ZonedDateTime dataInicio;

    private final ZonedDateTime dataFim;

    public Curso(UUID id, NomeCurso nome, DescricaoCurso descricaoCurso, List<UUID> matriculas, List<Disciplina> disciplinas, List<SalaReservada> salaReservadas, ZonedDateTime dataInicio, ZonedDateTime dataFim) {
        this.id = id;
        this.nome = nome;
        this.descricaoCurso = descricaoCurso;
        this.matriculas = matriculas;
        this.disciplinas = disciplinas;
        this.salaReservadas = salaReservadas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}
