package ru.fallindawn.booking.room.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Long capacity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType typeClass;

    @Column
    private BigDecimal price;

}
