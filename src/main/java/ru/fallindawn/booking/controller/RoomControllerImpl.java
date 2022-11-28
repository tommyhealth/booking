package ru.fallindawn.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;
import ru.fallindawn.booking.service.RoomService;
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
    public List<RoomDto> getByData(SearchRequestDto searchRequestDto) {
        return roomService.getByData(searchRequestDto);
    }
}
