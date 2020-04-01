/**
author: Arvind
Task
Complete the Difference class by writing the following:
   . A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.
   . A computeDifference method that finds the maximum absolute difference between any 2 numbers in N 
   and stores it in the maximumDifference instance variable. 

Sample Input
3
1 2 5

Sample Output
4

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
    Difference(int elements[]){
        this.elements = elements;
    }
	// Add your code here
    public void computeDifference(){
        int small,large;
        small = large = elements[0];
        for(int i=0;i<elements.length;i++){
            if(small>elements[i]){
                small=elements[i];
            }
            if(large<elements[i]){
                large=elements[i];
            }
        }
        this.maximumDifference = large-small;
    }
} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
