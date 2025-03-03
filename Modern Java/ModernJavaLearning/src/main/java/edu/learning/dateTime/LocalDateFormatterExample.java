package edu.learning.dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatterExample {
    private static LocalDate parseLocalDate(String date){
        return LocalDate.parse(date);
    }
    private static LocalDate parseLocalDateISOFormatted(String date){
        return LocalDate.parse(date,DateTimeFormatter.ISO_DATE);
    }
    private static LocalDate parseLocalDateCustomFormat(String date, String pattern){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }
    private static String formatLocalDate(LocalDate localDate,String requiredPattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(requiredPattern);
        return localDate.format(formatter);
    }
    public static void main(String[] args) {
        String date = "2025-03-03";
        System.out.println("parseLocalDate: "+parseLocalDate(date));
        System.out.println("parseLocalDateISOFormatted: "+ parseLocalDateISOFormatted(date));
        String date1 ="2025_03_03";
        String format1="yyyy_MM_dd";
        System.out.println("parseLocalDateCustomFormat: "+parseLocalDateCustomFormat(date1,format1));
        String date2 ="2025|03|03";
        String format2="yyyy|MM|dd";
        System.out.println("parseLocalDateCustomFormat: "+parseLocalDateCustomFormat(date2,format2));
        LocalDate localDate = LocalDate.of(2025,3,5);
        System.out.println("localDate: "+ localDate + " to string in format " +  format1 +": "+ formatLocalDate(localDate,format1));
        System.out.println("localDate: "+ localDate + " to string in format " +  format2 +": "+ formatLocalDate(localDate,format2));
    }
}
