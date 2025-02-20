package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

public class MapReduce {

    private static int noOfNotebooks(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::notebooks)
               // .reduce(0,(num1, num2) -> num1+num2);
                .reduce(0,Integer::sum);
    }

    private static int filterMapReduce(){
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.gradelevel()>3)
                .filter(student -> student.gender().equalsIgnoreCase("female"))
                .map(Student::notebooks)
                // .reduce(0,(num1, num2) -> num1+num2);
                .reduce(0,Integer::sum);
    }
    public static void main(String[] args) {
        System.out.println(noOfNotebooks());
        System.out.println(" Filter map reduce: ");
        System.out.println(filterMapReduce());
    }
}
