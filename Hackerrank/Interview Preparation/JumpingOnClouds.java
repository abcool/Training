package com.test;
import java.io.*;
import java.util.*;

class Result {
    
    public static int jumpingOnClouds(List<Integer> c) {
    // 0 0 1 0 0 1 0	
    
    // Write your code here
        int no_of_jumps=0;

       // Method 1 
       /* int i=0;
        int size=c.size();
        while(i<size-1){
            if(((i+2)<size) && (c.get(i+2)!=1)){
                no_of_jumps+=1;
                i+=2;
                continue;
            }
            if(((i+1)<size) && (c.get(i+1)!=1)){
                no_of_jumps+=1;
                i+=1;
                continue;
            }
            //i++;
        }*/
        
     // Method 2
        int i=0;
        while(i < c.size() - 1) {
            if (c.get(i) == 0) 
            	i++;
            no_of_jumps++;
            i++;
        }
        
        return no_of_jumps;
    }

}

public class Test {
    public static void main(String[] args) throws IOException {
    	Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> cloudList = new ArrayList<>();
        while(n>0) {
        cloudList.add(scan.nextInt());
        n--;
        }
        scan.close();
        // 0 0 1 0 0 1 0
        int result = Result.jumpingOnClouds(cloudList);
        System.out.println(result);
        
    }
}