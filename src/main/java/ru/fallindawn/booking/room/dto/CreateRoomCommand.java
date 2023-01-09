package ru.fallindawn.booking.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.fallindawn.booking.room.domain.RoomType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateRoomCommand {

    @NotNull
    private Long capacity;

    @NotNull
    @NotBlank
    private RoomType typeClass;

    @NotNull
    private BigDecimal price;
}
