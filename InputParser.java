package org.example;

import org.example.exceptions.IncorrectException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputParser {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public static Record parseRecord(String line) throws ParseException {
        String[] parts = line.trim().split(" ");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Incorrect recording format: " + line);
        }
        String serviceId = parts[1];
        String questionTypeId = parts[2];
        char responseType = parts[3].charAt(0);
        java.util.Date date = DATE_FORMAT.parse(parts[4]);
        int waitingTime = Integer.parseInt(parts[5]);

        return new Record(serviceId, questionTypeId, responseType, date, waitingTime);
    }

    public static Query parseQuery(String line) throws ParseException {
        String[] parts = line.trim().split(" ");
        if (parts.length != 5) {
            throw new IncorrectException("Invalid request format: " + line);
        }
        String serviceIdPattern = parts[1];
        String questionTypeIdPattern = parts[2];
        char responseType = parts[3].charAt(0);
        String[] dateRange = parts[4].split("-");
        java.util.Date dateFrom = DATE_FORMAT.parse(dateRange[0]);
        java.util.Date dateTo = dateRange.length == 2 ? DATE_FORMAT.parse(dateRange[1]) : dateFrom;

        return new Query(serviceIdPattern, questionTypeIdPattern, responseType, dateFrom, dateTo);
    }
}
