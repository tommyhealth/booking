package ru.fallindawn.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.service.Impl.RoomService;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements IRoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    @Override
    public List<RoomDto> findAll() {
        return roomService.findAll();
    }
}
