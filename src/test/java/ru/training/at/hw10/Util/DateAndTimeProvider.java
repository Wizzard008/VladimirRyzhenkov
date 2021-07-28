package ru.training.at.hw10.Util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeProvider {
    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
