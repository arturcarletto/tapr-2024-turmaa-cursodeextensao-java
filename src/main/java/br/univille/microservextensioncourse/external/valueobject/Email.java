package br.univille.microservextensioncourse.external.valueobject;

import lombok.Data;

@Data
public class Email {

    private final String email;

    public Email(String email) {
        this.email = email;
    }
}
