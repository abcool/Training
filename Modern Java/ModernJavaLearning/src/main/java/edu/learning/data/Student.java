package edu.learning.data;

import java.util.List;

public record Student(String name, int gradelevel, double gpa, String gender, List<String> activities, int notebooks) {
    public Student(String s) {
        this(s,3,4.5,"Male",List.of("cricket"),10);
    }


    public void printActivities(){
    System.out.println(activities);
}
}
