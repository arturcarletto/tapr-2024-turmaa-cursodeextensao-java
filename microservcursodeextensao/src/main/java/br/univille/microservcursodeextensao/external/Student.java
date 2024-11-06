package br.univille.microservcursodeextensao.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import br.univille.microservcursodeextensao.external.valueobject.CPF;
import br.univille.microservcursodeextensao.external.valueobject.Email;
import br.univille.microservcursodeextensao.external.valueobject.Name;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    private UUID id;

    private Name name;

    private CPF cpf;

    private Email email;

}
