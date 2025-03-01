package edu.learning.interfaceMethods;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethod {
    private static Comparator<Student> nameComparator = Comparator.comparing(Student::name);
    private static void sortByName(List<Student> studentList){
        studentList.sort(nameComparator);
        studentList.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Adam","Eve","Jonny","Louis","Emily","Jack");
        /**
         * Before java 8
         */
        Collections.sort(names);
        System.out.println(" Sorting using Collections.sort(): ");
        System.out.println(names);
        /**
         * Java 8
         */
        List<String> names2 = Arrays.asList("Adam","Eve","Jonny","Louis","Emily","Jack");
        names2.sort(Comparator.naturalOrder());
        System.out.println(" Sorting using List.sort(): ");
        System.out.println(names2);
        System.out.println(" Sorting using List.sort(reversed): ");
        names2.sort(Comparator.reverseOrder());
        System.out.println(names2);


        //
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(System.out::println);
        System.out.flush();
        System.out.println(" Sorting Students by name: ");
        sortByName(studentList);
        studentList.sort(Comparator.comparingDouble(Student::gpa));
        System.out.println(" Sorted by gpa: ");
        studentList.forEach(System.out::println);
        studentList.sort(Comparator.comparingDouble(Student::gradelevel).thenComparing(Student::name));
        System.out.println(" Comparator chaining: ");
        studentList.forEach(System.out::println);
    }
}
