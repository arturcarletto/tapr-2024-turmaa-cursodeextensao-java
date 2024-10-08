package external;

import java.util.UUID;

public class Sala {

    private final UUID id;

    private final char bloco;

    private final int numero;

    private final int capacidade;

    private final boolean computador;

    public Sala(UUID id, char bloco, int numero, int capacidade, boolean computador) {
        this.id = id;
        this.bloco = bloco;
        this.numero = numero;
        this.capacidade = capacidade;
        this.computador = computador;
    }

}
