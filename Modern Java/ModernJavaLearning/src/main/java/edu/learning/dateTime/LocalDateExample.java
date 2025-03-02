package edu.learning.dateTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: "+ localDate);
        LocalDate localDate1 = LocalDate.of(2025,03,02);
        System.out.println("localDate1: "+ localDate1);
        LocalDate localDate2 = LocalDate.ofYearDay(2025,364);
        System.out.println("localDate2: "+ localDate2);
        System.out.println("Getting year: "+ localDate.getYear());
        System.out.println(" Getting month: "+ localDate.getMonth());
        System.out.println(" Getting month numeric: "+ localDate.getMonthValue());
        System.out.println(" Getting day: "+ localDate.getDayOfWeek());
        System.out.println(" Getting day numeric: "+ localDate.getDayOfMonth());
        System.out.println(" Getting day of the year: "+ localDate.getDayOfYear());
        System.out.println(" Getting day using temporal: "+ localDate.get(ChronoField.DAY_OF_WEEK));
        System.out.println(" Getting day using temporal2: "+ localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println(" Original date: "+ localDate);
        System.out.println(" Plus 2 days: "+ localDate.plusDays(2));
        System.out.println(" Plus 2 months: "+ localDate.plusMonths(2));
        System.out.println(" Original date: "+ localDate1);
        System.out.println(" Minus Day: "+ localDate1.minusDays(1));
        System.out.println(" Original date: "+ localDate2);
        System.out.println(" With year: "+ localDate2.withYear(2026));
        System.out.println(" With Temporal changing year: "+ localDate2.with(ChronoField.YEAR,2027));
        System.out.println(" Original date: "+ localDate1);
        System.out.println(" With Temporal adjuster: "+ localDate1.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(" Original date: "+ localDate1);
        System.out.println(" Subtracting year using chronoUnit: "+ localDate.minus(1, ChronoUnit.YEARS));
        System.out.println(" Checking leap year: "+ localDate.isLeapYear());
        System.out.println(" Checking if two dates are equal: "+ localDate.isEqual(localDate1));
        System.out.println(" Is date before: "+ localDate.isBefore(localDate1));
        System.out.println(" Is date after: "+ localDate2.isAfter(localDate1));
        // checking field is supported
        System.out.println(" Is supported: "+ localDate.isSupported(ChronoUnit.MINUTES));
        System.out.println(" Is supported: "+ localDate.isSupported(ChronoField.YEAR));
    }
}
