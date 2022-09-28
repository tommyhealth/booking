package ru.fallindawn.booking.controller;

import ru.fallindawn.booking.dto.RoomDto;

import java.util.List;

public interface IRoomController {

    List<RoomDto> findAll();

}
