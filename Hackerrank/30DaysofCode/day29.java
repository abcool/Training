/**
@author: Arvind Bakshi
Given set S={1,2,3,.....N}. Find two integers, A and B (where A<B), from set S such that the value of A&B is the maximum possible 
and also less than a given integer, K. In this case, & represents the bitwise AND operator.

Sample Input
3
5 2
8 5
2 2

Sample Output
1
4
0
*/
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
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);// for e.g. N=5

            int k = Integer.parseInt(nk[1]); // for e.g. k=2
            int max=0;
            for(int i=1;i<n;i++){ // i= 1 to 4
                for(int j=i+1;j<=n;j++){ // j= 2 to 5
                    int val=i&j;
                    if(val<k){ // don't add result of i&j to list if greater than k 
                        if(max<val){
                            max=val;
                        }
                    }
                }
            }
            System.out.println(max);
        }

        scanner.close();
    }
}
