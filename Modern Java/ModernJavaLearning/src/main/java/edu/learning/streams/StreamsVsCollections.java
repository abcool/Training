package edu.learning.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsVsCollections {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Neha");
        names.add("Rahul");
        names.add("Lakshmi");
        names.add("Aakash");
        System.out.println("Original names");
        for (String name:names){
            System.out.println(name);
        }
        names.add("Richa");
        names.remove("Aakash");
        System.out.println("After list is modified");
        for (String name:names){
            System.out.println(name);
        }

        // Adding or removing elements from streams not allowed
        // names.stream()
              //  .add
              //  .remove

        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);

        // not allowed to traverse same stream again
       // nameStream.forEach(System.out::println);
    }
}
