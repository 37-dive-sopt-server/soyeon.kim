package org.sopt.global.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateFormatUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private DateFormatUtil() {}

    public static String format(LocalDate date) {
        return date.format(FORMATTER);
    }
}
