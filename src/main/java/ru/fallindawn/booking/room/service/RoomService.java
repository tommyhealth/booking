package ru.fallindawn.booking.room.service;

import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRequestDto;
import java.util.List;

public interface RoomService {

      List<RoomDto> findByDate(SearchRequestDto searchRequestDto);

      List<RoomDto> findAll();

      RoomDto createRoom(RoomDto roomDto);
}
