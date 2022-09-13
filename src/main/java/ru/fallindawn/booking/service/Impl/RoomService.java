package ru.fallindawn.booking.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;
import ru.fallindawn.booking.mapper.RoomMapper;
import ru.fallindawn.booking.repository.RoomRepository;
import ru.fallindawn.booking.service.IRoomService;
import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDto> getByData(SearchRequestDto searchRequestDto) {
        return null;
    }
}
