package ru.fallindawn.booking.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.room.dto.CreateRoomCommand;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRoomQuery;
import ru.fallindawn.booking.room.service.RoomService;
import java.util.List;

@RestController
public class RoomControllerImpl implements RoomController {

    @Autowired
    private RoomService roomService;

    @Override
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }

    @Override
    public List<RoomDto> getFreeRoomsByDate(SearchRoomQuery searchRoomQuery) {
        return roomService.findFreeRoomsByDate(searchRoomQuery);
    }

    @Override
    public RoomDto createRoom(CreateRoomCommand createRoomCommand) {
        return roomService.createRoom(createRoomCommand);
    }
}
