package br.univille.microservcursodeextensao.course;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservedClassroom {

    private final UUID classroom;

    private final LocalDateTime ReserveStart;

    private final LocalDateTime ReserveEnd;

    public ReservedClassroom(UUID classroom, LocalDateTime ReserveStart, LocalDateTime ReserveEnd) {
        this.classroom = classroom;
        this.ReserveStart = ReserveStart;
        this.ReserveEnd = ReserveEnd;
    }
}
