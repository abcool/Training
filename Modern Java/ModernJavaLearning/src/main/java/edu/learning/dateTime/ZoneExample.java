package edu.learning.dateTime;

import java.time.*;

public class ZoneExample {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime: "+zonedDateTime);
        System.out.println("Zone offset: "+ zonedDateTime.getOffset());
        System.out.println("Zone ID: "+ zonedDateTime.getZone());
        //System.out.println("Printing all available zone Ids");
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(" No of zone Ids available: "+ ZoneId.getAvailableZoneIds().size());

        ZonedDateTime chicagoTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println(" Time in chicago now: "+ chicagoTime);
        System.out.println("Getting zoned time using clock: "+ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Kolkata"))));

        // setting zone while creating LocalDataTime
        System.out.println(" LocalDateTime with zone: "+ LocalDateTime.now(ZoneId.of("Asia/Kolkata")));

        System.out.println(" LocalDateTime with zone using clock: "+ LocalDateTime.now(Clock.system(ZoneId.of("Asia/Kolkata"))));

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault());
        System.out.println(" Instant with zone: "+ localDateTime);

        // Converting LocalDateTime to ZonedDateTime

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("localDateTime -> ZonedDateTime: "+ localDateTime1.atZone(ZoneId.of("Asia/Kolkata")));

        // converting instant to ZonedDateTime

        Instant instant = Instant.now();

        System.out.println("instant -> zonedDateTIme: "+instant.atZone(ZoneId.of("America/Chicago")));

        System.out.println("Offset demo: "+localDateTime.atOffset(ZoneOffset.ofHours(2)));
    }
}
