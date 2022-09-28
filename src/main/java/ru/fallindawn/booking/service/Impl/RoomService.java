package ru.fallindawn.booking.service.Impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.domain.Registration;
import ru.fallindawn.booking.dto.RoomDto;
import ru.fallindawn.booking.dto.SearchRequestDto;
import ru.fallindawn.booking.mapper.RoomMapper;
import ru.fallindawn.booking.repository.RegistrationRepository;
import ru.fallindawn.booking.repository.RoomRepository;
import ru.fallindawn.booking.service.IRoomService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDto> findAll() {
        log.info("Get all rooms");
        return roomRepository.findAll().stream()
                .map(room -> roomMapper.roomToDto(room))
                .collect(Collectors.toList());
    }

    public List<RoomDto> getByData(SearchRequestDto searchRequestDto) {
        var dateFrom = searchRequestDto.getDateFrom();
        var dateTo = searchRequestDto.getDateTo();
        var reservedRooms = registrationRepository.findDistinctByRoomBetween(dateFrom, dateTo).stream()
                .map(Registration::getRoomId)
                .collect(Collectors.toList());

        return roomRepository.findAllByCapacity(searchRequestDto.getCapacity()).stream()
                .filter(room -> !reservedRooms.contains(room.getId()))
                .map(room -> roomMapper.roomToDto(room))
                .collect(Collectors.toList());

    }
}
