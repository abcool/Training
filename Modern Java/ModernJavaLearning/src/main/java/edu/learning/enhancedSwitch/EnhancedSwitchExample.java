package edu.learning.enhancedSwitch;

import java.time.Year;

public class EnhancedSwitchExample {
    private static int getDays(String month, int year){
        return switch (month){
            case "SEPTEMBER","APRIL","JUNE","NOVEMBER" -> 30;
            case "FEBURARY" -> Year.isLeap(year) ? 29:28;
            default -> 31;
        };
    }

    private static int getDaysV2(String month, int year){
        return switch (month){
            case "SEPTEMBER","APRIL","JUNE","NOVEMBER" -> 30;
            case "FEBURARY" -> {
                System.out.println(" Checking if Feb is in leap year");
                yield Year.isLeap(year) ? 29:28;
            }
            default -> 31;
        };
    }
    public static void main(String[] args) {
        System.out.println("Number of days in Feb 2025 is: "+ getDays("FEBURARY",2025));
        System.out.println("Number of days in JUNE 2025 is: "+ getDays("JUNE",2025));
        System.out.println("Number of days in DECEMBER 2025 is: "+ getDays("DECEMBER",2025));
        System.out.println("Number of days in Feb 2025 is: "+ getDaysV2("FEBURARY",2025));
    }
}
