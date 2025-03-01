package edu.learning.interfaceMethods;


import java.util.List;
import java.util.stream.IntStream;

public class StaticDefaultImpl implements StaticDefault{

    @Override
    public int multiply(List<Integer> numList){
        return 2* numList.stream().reduce((num1,num2)->(num1*num2)).get();
    }
    public static void main(String[] args) {
        List<Integer> numList = IntStream.rangeClosed(1,5).boxed().toList();
        StaticDefaultImpl obj = new StaticDefaultImpl();
        int ans = obj.multiply(numList);
        System.out.println(" Mul ans = "+ ans);
        System.out.println(" Sum ans = "+ obj.sum(numList));
        System.out.println(" Size of list: "+ StaticDefault.size(numList));
    }
}
