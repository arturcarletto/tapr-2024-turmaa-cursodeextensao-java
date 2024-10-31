package br.univille.microservextensioncourse.external;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import br.univille.microservextensioncourse.external.valueobject.CPF;
import br.univille.microservextensioncourse.external.valueobject.Email;
import br.univille.microservextensioncourse.external.valueobject.Name;

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
