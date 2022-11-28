package ru.fallindawn.booking.room.service;

import org.springframework.stereotype.Service;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRequestDto;

import java.util.List;

@Service
public interface RoomService {

      List<RoomDto> getByData(SearchRequestDto searchRequestDto);

      List<RoomDto> findAll();

      RoomDto createRoom(RoomDto roomDto);
}
