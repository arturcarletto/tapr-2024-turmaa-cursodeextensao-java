package br.univille.microservcursodeextensao.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classroom {

    private String id;

    private char block;

    private int number;

    private int capacity;

    private boolean hasComputer;

}
