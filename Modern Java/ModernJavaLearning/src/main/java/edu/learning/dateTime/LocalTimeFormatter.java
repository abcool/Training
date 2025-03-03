package edu.learning.dateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class LocalTimeFormatter {
    private static void parseTime(){
        String time ="13:50";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("localTime: "+ localTime);
        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTime1: "+ localTime1);
        String time1 = "13_50";
        LocalTime localTime2 = LocalTime.parse(time1,DateTimeFormatter.ofPattern("HH_mm"));
        System.out.println("localTime2: "+ localTime2);
       String time2 = "02:50 PM".trim(); // Added AM/PM
//        LocalTime localTime3 = LocalTime.parse(time2,DateTimeFormatter.ofPattern("hh:mm a"));
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("hh:mm a")
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();

        LocalTime localTime3 = LocalTime.parse(time2, formatter);
        System.out.println("localTime3: "+ localTime3);
        String time3 = "13:50:30";
        LocalTime localTime4 = LocalTime.parse(time3,DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("localTime4: "+ localTime4);
    }

    private static void formatTime(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH_mm_ss");
        String strTime = localTime.format(formatter1);
        System.out.println("strTime: "+ strTime);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh_mm a");
        System.out.println("AM/PM formatted: "+ localTime.format(formatter2));
    }
    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}
