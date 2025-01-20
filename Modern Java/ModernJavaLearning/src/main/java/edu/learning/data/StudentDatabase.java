package edu.learning.data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {
    public static List<Student> getAllStudents (){
        return Arrays.asList(
                new Student("John",2,3.6,"male", Arrays.asList("swimming","basketball","volleyball")),
                new Student("Jenny",2,3.8,"female",Arrays.asList("swimming","gymnastics","soccer")),
                new Student("Emily",3,4.0,"female",Arrays.asList("swimming","gymnastics","aerobatics")),
                new Student("Dave",3,3.9,"male",Arrays.asList("swimming","gymnastics","soccer")),
                new Student("Sophia",4,3.5,"female",Arrays.asList("swimming","dancing","football")),
                new Student("James",4,3.9,"male",Arrays.asList("swimming","basketball","baseball","football"))
        );

    }
}
