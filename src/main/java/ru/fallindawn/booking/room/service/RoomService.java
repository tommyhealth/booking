package ru.fallindawn.booking.room.service;

import ru.fallindawn.booking.room.dto.CreateRoomCommand;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRoomQuery;
import java.util.List;

public interface RoomService {

      List<RoomDto> findByDate(SearchRoomQuery searchRoomQuery);

      List<RoomDto> findAll();

      RoomDto createRoom(CreateRoomCommand createRoomCommand);
}
