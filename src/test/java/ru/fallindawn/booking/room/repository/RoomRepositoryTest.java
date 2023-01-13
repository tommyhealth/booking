package ru.fallindawn.booking.room.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import ru.fallindawn.booking.AbstractIntegrationTest;

import javax.transaction.Transactional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.fallindawn.booking.room.repository.RoomTestEntities.*;

@SpringBootTest
@DirtiesContext
@WithMockUser(username = "user")
class RoomRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    @Transactional
    @DisplayName("findAll three rooms in db returns three rooms")
    void findAll_threeRoomsInDB_returnsThreeRooms() {
        roomRepository.saveAll(asList(ROOM_1, ROOM_2, ROOM_3));
        var result = roomRepository.findAll();
        assertEquals(3, result.size());
    }
}
