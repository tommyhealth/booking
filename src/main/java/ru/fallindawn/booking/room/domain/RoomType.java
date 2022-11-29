package ru.fallindawn.booking.room.domain;

public enum RoomType {
    GRAND("grand"),
    STANDARD("standard"),
    SUPERIOR("fuck"),
    DELUXE("fuck"),
    FAMILY("fuck"),
    TRIPLE("fuck");

    public String name;

    public String getName() {
        return name;
    }

    RoomType(String name) {
        this.name = name;
    }
}
