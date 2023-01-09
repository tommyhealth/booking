package ru.fallindawn.booking.room.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.room.domain.Room;
import ru.fallindawn.booking.room.dto.RoomDto;

@Mapper(componentModel = "spring", uses=RoomTypeMapper.class)
@Component
public interface RoomMapper extends RoomTypeMapper {

    RoomDto toDto(Room room);

    Room toEntity(RoomDto roomDto);
}
