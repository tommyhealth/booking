package ru.fallindawn.booking.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String phone;

    @Column
    private String name;

    @Column(name = "second_name")
    private String secondName;

}


