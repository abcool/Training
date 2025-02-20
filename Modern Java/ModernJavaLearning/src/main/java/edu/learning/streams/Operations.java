package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Operations {
    private static Comparator<Student> sortByGrade = (student1,student2) -> student1.gradelevel()>student2.gradelevel()?1:0;

    private static List<String> getUniqueActivities(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::activities)
                .flatMap(List::stream)
                .distinct()
                .toList();
    }
    private static long activityCount(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::activities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }
    private static List<String> sortedActivities(){
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::activities)
                .flatMap(List::stream)
                .sorted()
                .toList();
    }

    private static List<Student> sortedByName(){
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::name))
                .toList();
    }
    private static List<Student> sortedByGradeLevel(){
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(sortByGrade)
                .toList();
    }
    private static  List<Student> sortByGPA(){
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::gpa))
                .toList();
    }
    public static void main(String[] args) {
     //   System.out.println(getUniqueActivities());
     //   System.out.println(activityCount());
     //   System.out.println(sortedActivities());
//        System.out.println("Sorted by Name: ");
//        sortedByName().forEach(System.out::println);
//        System.out.println("Sorted by Grade Level: ");
//        sortedByGradeLevel().forEach(System.out::println);
//        System.out.println("Sorted by GPA: ");
//        sortByGPA().forEach(System.out::println);

    }
}
