package ru.fallindawn.booking.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.domain.Room;
import ru.fallindawn.booking.dto.RoomDto;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

    RoomDto roomToDto(Room room);
}
