package ru.fallindawn.booking.room.repository;

import ru.fallindawn.booking.room.domain.Room;
import ru.fallindawn.booking.room.domain.RoomType;

import java.math.BigDecimal;
import java.util.UUID;

public final class RoomTestEntities {

    public static final Room ROOM_1 = Room.builder()
            .id(UUID.randomUUID())
            .typeClass(RoomType.FAMILY)
            .capacity(1L)
            .price(BigDecimal.valueOf(356))
            .build();

    public static final Room ROOM_2 = Room.builder()
            .id(UUID.randomUUID())
            .typeClass(RoomType.SUPERIOR)
            .capacity(2L)
            .price(BigDecimal.valueOf(50505))
            .build();

    public static final Room ROOM_3 = Room.builder()
            .id(UUID.randomUUID())
            .typeClass(RoomType.DELUXE)
            .capacity(3L)
            .price(BigDecimal.valueOf(10110))
            .build();
}
