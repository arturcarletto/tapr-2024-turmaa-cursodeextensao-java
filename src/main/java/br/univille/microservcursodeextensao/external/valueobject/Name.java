package br.univille.microservcursodeextensao.external.valueobject;

import lombok.Data;

@Data
public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

}
