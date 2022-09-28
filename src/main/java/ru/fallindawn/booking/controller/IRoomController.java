package ru.fallindawn.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.dto.RoomDto;

import java.util.List;

@RequestMapping("/room")
public interface IRoomController {

    @GetMapping
    List<RoomDto> findAll();

}
