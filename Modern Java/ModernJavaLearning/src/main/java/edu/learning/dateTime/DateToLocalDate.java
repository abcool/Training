package edu.learning.dateTime;

import java.time.*;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;

public class DateToLocalDate {
    public static void main(String[] args) {

        /**
         * Date to localdate, localdatetime, zonedDateTime
         */
        Date date = new Date();
        System.out.println(" Original date: "+ date);
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.of("Asia/Kolkata"))
                .toLocalDate();
        System.out.println(" Localdate from date: "+ localDate);
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.of("Asia/Kolkata"))
                .toLocalDateTime();
        System.out.println(" localdatetime from localdate: "+ localDateTime);
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("zonedDateTime from date:  "+ zonedDateTime);

        /**
         * LocalDate to date
         * LocaldateTime to date
         * ZonedDateTime to date
         */
        Date date1 = Date.from(localDate
                        .atTime(LocalTime.now())
                        .atZone(ZoneId.of("Asia/Kolkata"))
                        .toInstant());
        System.out.println("Date from localdate: "+ date1);
        Date date2 = Date.from(localDateTime
                .atZone(ZoneId.of("Asia/Kolkata"))
                .toInstant());
        System.out.println("Date from localdatetime: "+ date2);
        Date date3 = Date.from(zonedDateTime.toInstant());
        System.out.println("Date from zonedDateTime: "+ date3);

        /**
         * java.sql date to various date formats & vice versa
         */
        java.sql.Date date4 = java.sql.Date.valueOf(localDate);
        System.out.println(" localDate to java.sql.Date: "+ date4);
        java.sql.Date date5 = java.sql.Date.valueOf(localDateTime.toLocalDate());
        System.out.println("localDateTime to java.sql.Date: "+ date5);
        java.sql.Date date6 = java.sql.Date.valueOf(zonedDateTime.toLocalDate());
        System.out.println("zonedDateTime to java.sql.Date: "+ date6);
        LocalDate date7 = date4.toLocalDate();
        System.out.println(" java.sql.Date to LocalDate: "+ date7);
        LocalDateTime dateTime = LocalDateTime.of(date5.toLocalDate(),LocalTime.now());
        System.out.println("java.sql.Date to LocalDateTime: "+ dateTime);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(date6.toLocalDate(),LocalTime.now(),ZoneId.of("Asia/Kolkata"));
        System.out.println("java.sql.Date to zonedDateTime: "+ zonedDateTime1);
    }
}
