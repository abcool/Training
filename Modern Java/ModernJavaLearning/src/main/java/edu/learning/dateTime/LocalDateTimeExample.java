package edu.learning.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(" Current: "+ localDateTime);
        System.out.println(" Get day of month: "+ localDateTime.getDayOfMonth());
        System.out.println("Get hour of day: "+ localDateTime.getHour());
        System.out.println("Get hour(12-hour format): "+ localDateTime.get(ChronoField.HOUR_OF_AMPM));
        System.out.println("Get minutes: "+ localDateTime.getMinute());
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTime1: "+localDateTime1);

        /**
         * Modifying localDatetime
         */
        System.out.println("Original datetime: "+ localDateTime);
        System.out.println("Plus 2 hours: "+localDateTime.plusHours(2).get(ChronoField.HOUR_OF_AMPM));
        System.out.println("Minus 30 min: "+ localDateTime.minusMinutes(30).getMinute());
        System.out.println("Changed month to 11: "+localDateTime.withMonth(11));
        // convert localdate to localdateTime
        LocalDate localDate = LocalDate.of(2025,05,03);
        System.out.println("LocalDateTime from localdate: "+ localDate.atTime(LocalTime.of(19,50)));
        // convert localTime to localdateTime
        LocalTime localTime = LocalTime.MIDNIGHT;
        System.out.println("LocalTime to LocalDateTime: "+ localTime.atDate(localDate));
        // getting localDate & localTime from localDateTime
        System.out.println("LocalDate from localDateTime: "+ localDateTime.toLocalDate());
        System.out.println("LocalTime from localDateTime: "+ localDateTime.toLocalTime());

    }
}
