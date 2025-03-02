package edu.learning.dateTime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2025,01,01);
        LocalDate localDate1 = LocalDate.of(2025,12,31);
        Period period = localDate.until(localDate1);
        System.out.println("months diff: "+period.getMonths());// 31-1
        System.out.println(" Days diff: "+ period.getDays());// 12-1
        Period period1 = Period.ofDays(10);
        System.out.println(" Days in period: "+ period1.getDays());
        Period period2 = Period.ofYears(5);
        System.out.println("Years in period: "+ period2.getYears());
        System.out.println("Months in period: "+ period2.toTotalMonths());
        Period period3 = Period.between(localDate,localDate1);
        System.out.println(" period3:  "+ period3.getYears() +" : "+ period3.getMonths() +" : "+ period3.getDays());
    }
}
