/*
Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.

Example 1:

Input:
N = 5
A[] = {1,2,3,5}
Output: 4

Example 2:

Input:
N = 10
A[] = {6,1,2,8,3,4,7,10,5}
Output: 9

--------------------------------------------------------------------------------------------------------------------------
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ A[i] ≤ 106

*/
import java.io.*;
import java.util.*;

class Solution {
    int MissingNumber(int array[], int n) {
        // Your Code Here
        /*Arrays.sort(array);
        for(int i=0;i<array.length;i++)
            if(array[i]!=i+1){
                return i+1;
            }
        return array.length+1;*/
        int arraySum = (n*(n+1))/2;
        for(int i=0;i<array.length;i++){
            arraySum-=array[i];
        }
        return arraySum;
    }
}
public class MissingNumInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.MissingNumber(array, n));
        }
    }
}