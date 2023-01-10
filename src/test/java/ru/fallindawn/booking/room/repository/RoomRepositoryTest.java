package ru.fallindawn.booking.room.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.fallindawn.booking.AbstractIntegrationTest;

import javax.transaction.Transactional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static ru.fallindawn.booking.room.repository.TestEntities.ROOM_1;
import static ru.fallindawn.booking.room.repository.TestEntities.ROOM_2;
import static ru.fallindawn.booking.room.repository.TestEntities.ROOM_3;

@SpringBootTest
class RoomRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    @Transactional
    void givenThreeRoomsInDB_whenFindAll_thenReturnsThreeRooms() {
        roomRepository.saveAll(asList(ROOM_1, ROOM_2, ROOM_3));
        var result = roomRepository.findAll();
        assertEquals(3, result.size());
    }
}
