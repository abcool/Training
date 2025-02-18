package edu.learning.data;

import java.util.List;

public record Student(String name, int gradelevel, double gpa, String gender, List<String> activities) {
    public Student(String s) {
        this(s,3,4.5,"Male",List.of("cricket"));
    }


    public void printActivities(){
    System.out.println(activities);
}
}
