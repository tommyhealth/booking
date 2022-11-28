package ru.fallindawn.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fallindawn.booking.domain.Client;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private UUID clientId;
    private Client client;
    private UUID roomId;
    private Instant dateFrom;
    private Instant dateTo;
}
