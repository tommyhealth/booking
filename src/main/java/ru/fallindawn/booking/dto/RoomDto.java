package ru.fallindawn.booking.dto;

import ru.fallindawn.booking.domain.Client;
import ru.fallindawn.booking.domain.RoomType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class RoomDto {
    private UUID id;
    private Client client;
    private Long capacity;
    private Enum<RoomType> typeClass;
    private BigDecimal price;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Enum<RoomType> getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(Enum<RoomType> typeClass) {
        this.typeClass = typeClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
