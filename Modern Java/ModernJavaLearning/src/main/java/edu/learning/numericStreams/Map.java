package edu.learning.numericStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Map {
    private static List<Double> mapToObj(){
        return IntStream.rangeClosed(1,10)
                .mapToObj(x-> Double.parseDouble(String.valueOf(x)))
                .toList();
    }

    private static long mapToLong(){
        Stream<String> numStr = Stream.of("1","2","3");
        return numStr.mapToLong(Long::valueOf).sum();
    }

    private static double[] mapToDouble(){
        Stream<String> numStr = Stream.of("1","2","3");
        return numStr
                .mapToDouble(Double::valueOf)
                .toArray();
    }
    public static void main(String[] args) {
//        System.out.println(mapToObj());
//        System.out.println("Map to long: "+mapToLong());
        Arrays.stream(mapToDouble()).forEach(System.out::println);
    }
}
