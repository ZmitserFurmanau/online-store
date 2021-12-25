package com.onlinestore.app.component;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date time converter.
 */
public class LocalDateTimeConverter extends DozerConverter<LocalDateTime, String> {


    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Instantiates a new Local date time converter.
     */
    public LocalDateTimeConverter() {
        super(LocalDateTime.class, String.class);
    }

    @Override
    public String convertTo(final LocalDateTime localDateTime, final String date) {
        return localDateTime.format(formatter);
    }

    @Override
    public LocalDateTime convertFrom(final String date, final LocalDateTime localDateTime) {
        return LocalDateTime.parse(date, formatter);
    }
}
