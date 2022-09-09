package ru.fallindawn.booking.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column
    private UUID clientId;

    @Column
    private Long capacity;

    @Column
    private Enum<RoomType> typeClass;

    @Column
    private BigDecimal price;

    @Column
    private LocalDate checkIn;

    @Column
    private LocalDate checkOut;

}
