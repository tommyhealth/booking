package ru.fallindawn.booking.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "room", schema = "public")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "client_id")
    private UUID clientId;

    @Column
    private Long capacity;

    @Column(name = "type_class")
    private Enum<RoomType> typeClass;

    @Column
    private BigDecimal price;

    @Column(name = "check_in")
    private LocalDate checkIn;

    @Column(name = "check_out")
    private LocalDate checkOut;

}
