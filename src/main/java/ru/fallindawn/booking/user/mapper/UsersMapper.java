package ru.fallindawn.booking.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.user.domain.Users;
import ru.fallindawn.booking.user.dto.UserSignInOrUpCommand;
import ru.fallindawn.booking.user.dto.UserDto;

@Mapper(componentModel = "spring")
@Component
public interface UsersMapper {

    String GENERATE_UUID_EXPRESSION = "java(java.util.UUID.randomUUID())";

    @Mapping(target = "id", expression = GENERATE_UUID_EXPRESSION)
    Users toEntity(UserSignInOrUpCommand users);

    UserDto toDto(Users user);
}
