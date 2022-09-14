package ru.fallindawn.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fallindawn.booking.domain.Client;
import ru.fallindawn.booking.domain.RoomType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private UUID id;
    private Client client;
    private Long capacity;
    private Enum<RoomType> typeClass;
    private BigDecimal price;
    private LocalDate checkIn;
    private LocalDate checkOut;


}
