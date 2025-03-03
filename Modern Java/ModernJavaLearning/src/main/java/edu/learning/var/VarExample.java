package edu.learning.var;

import java.util.List;
import java.util.Map;

public class VarExample {
    public static void main(String[] args) {
        var nameList = List.of("Rahul","Sonia","Vicky");
        System.out.println(nameList);
        var students = Map.ofEntries(
                Map.entry("Rahul",List.of("swimming","running")),
                Map.entry("Sonia",List.of("Reading","Badminton"))
        );
        System.out.println(students);
        for(var name:nameList){
            System.out.println("name: "+ name);
        }
    }
}
