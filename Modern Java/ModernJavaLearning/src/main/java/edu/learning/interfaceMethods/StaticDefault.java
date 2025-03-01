package edu.learning.interfaceMethods;

import java.util.List;

public interface StaticDefault {
    default int sum(List<Integer> numList){
        return numList.stream().reduce((num1,num2)->(num1+num2)).get();
    }
    default int multiply(List<Integer> numList){
        return numList.stream().reduce((num1,num2)->(num1*num2)).get();
    }
    static int size(List<Integer> numList){
        return numList.size();
    }
}
