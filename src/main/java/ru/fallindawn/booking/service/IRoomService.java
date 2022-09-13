package ru.fallindawn.booking.service;

import org.springframework.stereotype.Service;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;

import java.util.List;

@Service
public interface IRoomService {

      List<RoomDto> getByData(SearchRequestDto searchRequestDto);
}
