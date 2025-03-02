package edu.learning.dateTime;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println("Getting epoch seconds: "+ instant.getEpochSecond());
        // Starting value of Instant is Epoch 0 i.e. Jan 1, 1970
        Instant instant1 = Instant.ofEpochSecond(0);
        System.out.println("instant1: "+ instant1);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant,instant2);
        System.out.println("duration: "+duration.getNano());
    }
}
