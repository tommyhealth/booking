package ru.fallindawn.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "room_id")
    @ManyToMany
    @JoinColumn(name = "room")
    private Room room;

    @Column
    private LocalDate checkIn;

    @Column
    private  LocalDate checkOut;
}
