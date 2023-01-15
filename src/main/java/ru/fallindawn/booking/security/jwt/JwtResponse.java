package ru.fallindawn.booking.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class JwtResponse {
    private String token;
}
