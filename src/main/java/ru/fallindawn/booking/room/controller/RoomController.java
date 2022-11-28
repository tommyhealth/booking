package ru.fallindawn.booking.room.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRequestDto;

import java.util.List;

@RequestMapping("/room")
public interface RoomController {

    @GetMapping
    List<RoomDto> findAll();

    @PostMapping
    List<RoomDto> getByData(@RequestBody SearchRequestDto searchRequestDto);

    @PostMapping("/create")
    RoomDto createRoom(@RequestBody RoomDto roomDto);

}
