package edu.learning.data;

import java.util.List;
import java.util.Optional;

public record Student(String name, int gradelevel, double gpa, String gender, List<String> activities, int notebooks, Optional<Bike> bike) {
    public Student(String s) {
        this(s,3,4.5,"Male",List.of("cricket"),10,Optional.empty());
    }
    public Student(String name, int gradelevel, double gpa, String gender, List<String> activities, int notebooks){
        this(name, gradelevel, gpa, gender, activities, notebooks,Optional.empty());
    }

    public void printActivities(){
    System.out.println(activities);
}
}
