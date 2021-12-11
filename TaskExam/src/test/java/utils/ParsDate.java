package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParsDate {
    public LocalDateTime getDate(String setDate) {
        return LocalDateTime.parse(setDate, DateTimeFormatter.ofPattern(TestDataConst.time));
    }
}
