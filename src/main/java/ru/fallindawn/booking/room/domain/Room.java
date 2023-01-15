package ru.fallindawn.booking.room.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Long capacity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType typeClass;

    @Column(nullable = false)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.id) &&
                capacity.equals(room.capacity) &&
                typeClass == room.typeClass &&
                price.equals(room.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
