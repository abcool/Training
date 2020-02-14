/**
@author: Arvind Bakshi
Given a base-10 integer, n, convert it to binary (base-2). 
Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.

Sample Input 1
5

Sample Output 1
1

**/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String binary="";
        int count1=0,count2=0;
        while(n>0){
            int digit;
            digit=n%2;
            binary+=Integer.toString(digit);
            n=n/2;
        }
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                int j=i;
                count2=0;
                while(j<binary.length() && binary.charAt(j)!='0'){
                    count2++;
                    j++;
                }
            }
            if(count1<count2){
                count1=count2;
            }
        }
        System.out.println(count1);
        scanner.close();
    }
}
