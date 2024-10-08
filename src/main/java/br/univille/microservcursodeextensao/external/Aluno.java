package external;

import external.valueobject.CPF;
import external.valueobject.Email;
import external.valueobject.Nome;

import java.util.UUID;

public class Aluno {

    private final UUID id;

    private final Nome nome;

    private final CPF cpf;

    private final Email email;

    public Aluno(UUID id, Nome nome, CPF cpf, Email email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
