package edu.learning.functionalInterfaces.predicate;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.function.Predicate;

public class PredicateInterface {

    private static final Predicate<Integer> checkEven = num -> num%2==0;
    private static final Predicate<Integer> checkDivBy5 = num -> num%5==0;

    public static final Predicate<Student> filterByGrade = student -> student.gradelevel()>=3;

    public static final Predicate<Student> filterByGPA = student -> student.gpa()>=3.9;

    private static void filterStudentByGradeLevel(){
        StudentDatabase.getAllStudents().forEach(student -> {
            if(filterByGrade.test(student))
                System.out.println(student);
        });
    }
    private static void filterStudentByGpa(){
        StudentDatabase.getAllStudents().forEach(student -> {
            if(filterByGPA.test(student))
                System.out.println(student);
        });
    }

    private static void filterStudentsByGradeLevelAndGpa(){
        StudentDatabase.getAllStudents().forEach(student -> {
            if(filterByGrade.and(filterByGPA).test(student))
                System.out.println(student);
        });
    }
    public static void main(String[] args) {

      //  System.out.println("Number 4 is even: "+checkEven.test(4));

     //   System.out.println("Number 10 is divisible by 5: "+checkDivBy5.test(10));

//        System.out.println("Number 10 is divisible by both 2 and 5: "+ predicateAnd(10));
//        System.out.println("Number 9 is divisible by both 2 and 5: "+ predicateAnd(9));
//        System.out.println("Number 4 is divisible by 2 or 5: "+ predicateOr(4));
//        System.out.println("Negate the result of Number 9 is divisible by both 2 and 5: "+ predicateNegate(9));
      //  filterStudentByGradeLevel();
     //   filterStudentByGpa();
        filterStudentsByGradeLevelAndGpa();
    }

    private static boolean predicateAnd(int num){
        // predicate chaining
        return checkEven.and(checkDivBy5).test(num);
    }
    private static boolean predicateOr(int num){
        // predicate chaining
        return checkEven.or(checkDivBy5).test(num);
    }
    private static boolean predicateNegate(int num){
        return checkEven.and(checkDivBy5).negate().test(num);
    }
}
