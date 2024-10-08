package curso;

import java.time.LocalDateTime;
import java.util.UUID;

public class SalaReservada {

    private final UUID sala;

    private final LocalDateTime inicioReserva;

    private final LocalDateTime fimReserva;

    public SalaReservada(UUID sala, LocalDateTime inicioReserva, LocalDateTime fimReserva) {
        this.sala = sala;
        this.inicioReserva = inicioReserva;
        this.fimReserva = fimReserva;
    }
}
