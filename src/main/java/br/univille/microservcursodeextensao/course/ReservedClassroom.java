package br.univille.microservcursodeextensao.course;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservedClassroom {

    private final UUID classroom;

    private final LocalDateTime ReservedStart;

    private final LocalDateTime ReservedEnd;

    public ReservedClassroom(UUID classroom, LocalDateTime ReservedStart, LocalDateTime ReservedEnd) {
        this.classroom = classroom;
        this.ReservedStart = ReservedStart;
        this.ReservedEnd = ReservedEnd;
    }
}
