package ru.fallindawn.booking.room.mapper;

import org.mapstruct.Named;
import ru.fallindawn.booking.room.domain.RoomType;

public interface RoomTypeMapper {

    @Named("asString")
    String asString(RoomType roomType);
}
