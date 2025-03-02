package edu.learning.dateTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(7,50);
        LocalTime localTime1 = LocalTime.of(8,55);
        long minutes = localTime.until(localTime1, ChronoUnit.MINUTES);
        System.out.println(" Duration between localTime and localTime1: "+ minutes);
        Duration duration = Duration.between(localTime,localTime1);
        System.out.println(" Duration using between: "+ duration.toMinutes());
        Duration duration1 = Duration.ofHours(3);
        System.out.println("duration1: "+ duration1.toMinutes());

    }
}
