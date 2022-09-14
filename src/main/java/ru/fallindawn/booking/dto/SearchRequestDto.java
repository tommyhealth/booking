package ru.fallindawn.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {

    private LocalDate dateFrom;
    private LocalDate dateTo;


}
