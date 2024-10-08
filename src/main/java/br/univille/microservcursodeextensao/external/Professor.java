package external;

import java.util.UUID;

public class Professor {

    private final UUID professor;

    private final String nome;

    public Professor(UUID professor, String nome) {
        this.professor = professor;
        this.nome = nome;
    }
}
