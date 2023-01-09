package ru.fallindawn.booking.room.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.room.dto.CreateRoomCommand;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRoomQuery;

import java.util.List;

@RequestMapping("/room")
public interface RoomController {

    @GetMapping
    List<RoomDto> findAll();

    @PostMapping
    List<RoomDto> getByData(@RequestBody SearchRoomQuery searchRoomQuery);

    @PostMapping("/create")
    RoomDto createRoom(@RequestBody CreateRoomCommand createRoomCommand);

}
