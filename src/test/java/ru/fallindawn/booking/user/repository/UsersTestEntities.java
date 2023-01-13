package ru.fallindawn.booking.user.repository;

import ru.fallindawn.booking.user.domain.Users;

import java.util.UUID;

public final class UsersTestEntities {

    public static final Users USER_1 = Users.builder()
            .id(UUID.randomUUID())
            .login("user1")
            .password("password")
            .build();

    public static final Users USER_2 = Users.builder()
            .id(UUID.randomUUID())
            .login("user2")
            .password("password")
            .build();
}
