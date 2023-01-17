package ru.fallindawn.booking.utils.web.response;

import java.util.Collections;
import java.util.List;

public class ErrorResponse {
    private final List<ErrorItem> errors;

    private ErrorResponse(List<ErrorItem> errors) {
        this.errors = errors;
    }

    public static ErrorResponse of(ErrorItem... errorItems) {
        return new ErrorResponse(List.of(errorItems));
    }

    public static ErrorResponse of(List<ErrorItem> errorItems) {
        return new ErrorResponse(Collections.unmodifiableList(errorItems));
    }

    public static ErrorResponse of(String title, String details) {
        return of(new ErrorItem(title, details));
    }

    public List<ErrorItem> getErrors() {
        return this.errors;
    }
}
