package ru.fallindawn.booking.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private UUID clientId;
    private UUID roomId;
    private Instant dateFrom;
    private Instant dateTo;
}
