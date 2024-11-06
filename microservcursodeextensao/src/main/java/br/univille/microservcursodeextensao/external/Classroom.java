package br.univille.microservcursodeextensao.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classroom {

    private UUID id;

    private char block;

    private int number;

    private int capacity;

    private boolean hasComputer;

}
