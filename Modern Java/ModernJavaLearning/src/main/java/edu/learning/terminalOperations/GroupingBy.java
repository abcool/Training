package edu.learning.terminalOperations;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingBy {
    private static Map<String, List<Student>> groupByGender(){
        return StudentDatabase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::gender));
    }
    private static Map<String,List<Student>> groupByGPA(){
        return StudentDatabase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.gpa()>3.9?"Outstanding":"Average"));
    }

    private static Map<String,Map<String,List<Student>>> groupByGenderGpa(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::gender,
                        Collectors.groupingBy(student -> student.gpa()>3.9?"Outstanding":"Average")));
    }
    private static Map<String,Integer> notebooksPerStudent(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::name,
                        Collectors.summingInt(Student::notebooks)));
    }
    private static LinkedHashMap<String, Set<Student>> nameStudent(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors
                        .groupingBy(Student::name,LinkedHashMap::new,Collectors.toSet()));
    }
    private static Map<Integer, Optional<Student>> highestGPAStudentPerGrade(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::gradelevel,
                        Collectors.maxBy(Comparator.comparing(Student::gpa))));
    }

    private static Map<Integer, Student> collectingAndThen(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::gradelevel,Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Student::gpa)),Optional::get)));
    }

    private static Map<Integer, Student> lowestGPAStudentPerGrade(){
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::gradelevel,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::gpa)),Optional::get)));
    }
    public static void main(String[] args) {
        System.out.println(" Grouping by gender: ");
        System.out.println(groupByGender());
        System.out.println(" Grouping by gpa: ");
        System.out.println(groupByGPA());
        System.out.println(" Printing groupByGenderGpa: ");
        System.out.println(groupByGenderGpa());
        System.out.println(" Printing notebooksPerStudent: ");
        System.out.println(notebooksPerStudent());
        System.out.println(" Printing 3 params groupingBy: ");
        System.out.println(nameStudent());
        System.out.println("Printing highest GPA student in each grade: ");
        System.out.println(highestGPAStudentPerGrade());
        System.out.println(" Collecting and then");
        System.out.println(collectingAndThen());
        System.out.println("Printing lowest GPA student in each grade: ");
        System.out.println(lowestGPAStudentPerGrade());
    }
}
