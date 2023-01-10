package ru.fallindawn.booking.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@AllArgsConstructor
public class SearchRoomQuery {

    @NotNull
    private Instant dateFrom;

    @NotNull
    private Instant dateTo;

    @NotNull
    private Long capacity;
}
