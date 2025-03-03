package edu.learning.dateTime;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter {
    private static void parseLocalDateTime(){
        String localDateTimeString = "2025-03-03T13:50:50";
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeString);
        System.out.println("localDateTime: "+localDateTime);

        System.out.println("ISO_LOCAL_DATE_TIME version: " +LocalDateTime.parse(localDateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        String localDateTimeString1 = "2025_03_03T13_50_50";
        LocalDateTime localDateTime1 = LocalDateTime.parse(localDateTimeString1,DateTimeFormatter.ofPattern("yyyy_MM_dd'T'HH_mm_ss"));
        System.out.println("localDateTime1: "+ localDateTime1);
    }
    private static void formatLocalDateTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd'T'HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTimeString = localDateTime.format(dateTimeFormatter);
        System.out.println("dateTimeString: "+ dateTimeString);
    }
    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}
