package curso;

import curso.valueobject.*;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Disciplina {

    private final NomeDisciplina nome;

    private final UUID professor;

    private final Conteudo conteudo;

    private final CargaHoraria horas;

    private final ValorHora valor;

    private final List<ZonedDateTime> dias;

    private final LocalTime inicio;

    private final LocalTime fim;

    public Disciplina(NomeDisciplina nome, UUID professor, Conteudo conteudo, CargaHoraria horas, ValorHora valor, List<ZonedDateTime> dias, LocalTime inicio, LocalTime fim) {
        this.nome = nome;
        this.professor = professor;
        this.conteudo = conteudo;
        this.horas = horas;
        this.valor = valor;
        this.dias = dias;
        this.inicio = inicio;
        this.fim = fim;
    }


}
