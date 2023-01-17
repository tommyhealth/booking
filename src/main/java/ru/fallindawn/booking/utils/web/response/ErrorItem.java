package ru.fallindawn.booking.utils.web.response;

public class ErrorItem {
    private final String title;
    private final String details;

    public ErrorItem(String title) {
        this(title, null);
    }

    public ErrorItem(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDetails() {
        return this.details;
    }
}
