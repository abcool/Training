package edu.learning.streams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Reduce {

    private static BinaryOperator<Integer> multiply = (num1, num2) -> num1*num2;

    private static int getMulResult(List<Integer> list){
        return list.stream()
                .reduce(1,multiply);
    }

    private static Optional<Student> getHighestGradeStudent(){
        return StudentDatabase.getAllStudents()
                .stream()
                .reduce((student1, student2) -> student1.gradelevel()> student2.gradelevel()?student1:student2);
    }

    public static void main(String[] args) {
//        System.out.println(getMulResult(List.of(1,3,5,7)));
//        System.out.println(" reduce without identity: ");
//        System.out.println(List.of(1,3,5,7).stream().reduce(multiply).get());
//        System.out.println("Highest Grade student is ");
        System.out.println(getHighestGradeStudent().get());
    }
}
