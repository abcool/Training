package edu.learning.dateTime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(" Current time: "+ localTime);
        LocalTime localTime1 = LocalTime.of(20,50);
        System.out.println(" localTime1: "+ localTime1);
        LocalTime localTime2 = LocalTime.of(22,15,40);
        System.out.println("localTime2: "+ localTime2);
        LocalTime localTime3 = LocalTime.of(19,30,50,80000);
        System.out.println("localTime3: "+ localTime3);
        System.out.println(" localTime1 hour: "+ localTime1.getHour());
        System.out.println(" localTime1 minute: " + localTime1.getMinute());
        System.out.println(" localTime1 seconds: "+ localTime1.getSecond());
        System.out.println(" localTime1 hour using chronoField: "+ localTime1.get(ChronoField.HOUR_OF_DAY));
        System.out.println(" localTime1 hour(12-format) using chronoField: "+ localTime1.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println(" localTime1 minute using chronofield: "+ localTime1.get(ChronoField.MINUTE_OF_HOUR));

        /**
         * Modify time
         */

        System.out.println(" Original time: "+ localTime2);
        System.out.println("Hours minus: " +localTime2.minusHours(10));

        System.out.println(" Minutes minus using chrono unit: "+ localTime2.minus(10,ChronoUnit.MINUTES));
        System.out.println(" changing time using With: "+ localTime2.with(LocalTime.MIDNIGHT));
        System.out.println(" changing hour using With: "+ localTime2.with(ChronoField.HOUR_OF_DAY,19));
        System.out.println(" Changing minute: "+ localTime2.plusMinutes(40));
        System.out.println(" Changing hour: "+ localTime2.withHour(12));

    }
}
