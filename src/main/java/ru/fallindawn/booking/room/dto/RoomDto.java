package ru.fallindawn.booking.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fallindawn.booking.room.domain.RoomType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private UUID id;
    private Long capacity;
    private RoomType roomType;
    private BigDecimal price;
}
