package ru.fallindawn.booking.dto;

import java.time.LocalDate;

public class SearchRequestDto {

    private LocalDate date_from;
    private LocalDate date_to;

    public LocalDate getDate_from() {
        return date_from;
    }

    public void setDate_from(LocalDate date_from) {
        this.date_from = date_from;
    }

    public LocalDate getDate_to() {
        return date_to;
    }

    public void setDate_to(LocalDate date_to) {
        this.date_to = date_to;
    }
}
