package edu.learning.parallelStreams;

import edu.learning.data.Student;
import edu.learning.data.StudentDatabase;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelVsSequential {
    private static long checkPerformance(Supplier<Integer> supplier, int times){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private static int sequentialStream(){
        return IntStream.rangeClosed(1,50000).sum();
    }
    private static int parallelStream(){
        return IntStream.rangeClosed(1,50000).parallel().sum();
    }

    private static void sequentialStreamFlatMap(){
        long startTime = System.currentTimeMillis();
        List<String> activities = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::activities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(" Sequential stream time taken: "+ (endTime-startTime));
    }

    private static void parallelStreamFlatMap(){
        long startTime = System.currentTimeMillis();
        List<String> activities = StudentDatabase.getAllStudents()
                .parallelStream()
                .map(Student::activities)
               // .peek(System.out::println)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(" Parallel stream time taken: "+ (endTime-startTime));
    }

    public static void main(String[] args) {
        System.out.println("No of processors: "+ Runtime.getRuntime().availableProcessors());
        System.out.println(" Sequential: ");
        System.out.println(checkPerformance(ParallelVsSequential::sequentialStream,20));
        System.out.println(" Parallel: ");
        System.out.println(checkPerformance(ParallelVsSequential::parallelStream,20));
        System.out.println("FlatMap performance comparison: ");
        sequentialStreamFlatMap();
        parallelStreamFlatMap();
    }
}
