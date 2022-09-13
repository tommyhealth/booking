package ru.fallindawn.booking.service.Impl;


import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;
import ru.fallindawn.booking.repository.RoomRepository;
import ru.fallindawn.booking.service.IRoomService;
import java.util.List;




public class RoomService implements IRoomService {

    private RoomRepository roomRepository;

    public List<RoomDto> getByData(SearchRequestDto searchRequestDto) {


    }
}
