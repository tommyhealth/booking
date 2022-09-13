package ru.fallindawn.booking.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.fallindawn.booking.domain.Client;
import ru.fallindawn.booking.domain.Room;
import ru.fallindawn.booking.domain.RoomType;
import ru.fallindawn.booking.dto.RoomDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoomMapperTest {

    @Autowired
    private RoomMapper roomMapper;

    @Test
    void roomToDtoTest() {
        Room room = new Room(
                UUID.randomUUID(),
                new Client(
                        UUID.randomUUID(),
                        "phone",
                        "name",
                        "secondName"
                ),
                10L,
                RoomType.DELUXE,
                BigDecimal.ONE,
                LocalDate.now(),
                LocalDate.now()
        );
        RoomDto roomDto = new RoomDto();

        RoomDto result = roomMapper.roomToDto(room);

        assertEquals("name", result.getClient().getName());

    }

}