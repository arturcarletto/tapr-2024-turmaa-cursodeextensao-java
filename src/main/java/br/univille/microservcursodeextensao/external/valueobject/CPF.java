package br.univille.microservcursodeextensao.external.valueobject;

import lombok.Data;

@Data
public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }
}
