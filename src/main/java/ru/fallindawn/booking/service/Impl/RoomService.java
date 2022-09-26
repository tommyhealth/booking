package ru.fallindawn.booking.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.domain.Registration;
import ru.fallindawn.booking.domain.Room;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;
import ru.fallindawn.booking.mapper.RoomMapper;
import ru.fallindawn.booking.repository.RegistrationRepository;
import ru.fallindawn.booking.repository.RoomRepository;
import ru.fallindawn.booking.service.IRoomService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDto> getByData(SearchRequestDto searchRequestDto) {
        List <UUID> reservedRoom = registrationRepository.findByRoomBetween(searchRequestDto.getDateFrom(), searchRequestDto.getDateTo()).stream()
                .map(Registration::getRoom)
                .map(Room::getId)
                .distinct()
                .collect(Collectors.toList());

        return roomRepository.findAllByCapacity(searchRequestDto.getCapacity()).stream()
                .filter(room -> !reservedRoom.contains(room.getId()))
                .map(room -> roomMapper.roomToDto(room))
                .collect(Collectors.toList());

    }
}
