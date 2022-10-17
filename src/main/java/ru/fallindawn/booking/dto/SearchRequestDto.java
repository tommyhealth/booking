package ru.fallindawn.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    private Instant dateFrom;
    private Instant dateTo;
    private Long capacity;
}
