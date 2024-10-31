package br.univille.microservextensioncourse.course;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservedClassroom {

    private final UUID classroom;

    private final LocalDateTime reserveStart;

    private final LocalDateTime reserveEnd;

    public ReservedClassroom(UUID classroom, LocalDateTime reserveStart, LocalDateTime reserveEnd) {
        this.classroom = classroom;
        this.reserveStart = reserveStart;
        this.reserveEnd = reserveEnd;
    }
}
