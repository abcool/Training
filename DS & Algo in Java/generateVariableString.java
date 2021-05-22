/*  
Generate all strings of length n drawn from 0...k-1

Output:

Enter the length of string: 4
Enter the variable values that can be taken: 3
Total possible strings are: 
[0, 0, 0, 0]
[1, 0, 0, 0]
[2, 0, 0, 0]
[0, 1, 0, 0]
[1, 1, 0, 0]
[2, 1, 0, 0]
[0, 2, 0, 0]
[1, 2, 0, 0]
[2, 2, 0, 0]
[0, 0, 1, 0]
[1, 0, 1, 0]
[2, 0, 1, 0]
[0, 1, 1, 0]
[1, 1, 1, 0]
[2, 1, 1, 0]
[0, 2, 1, 0]
[1, 2, 1, 0]
[2, 2, 1, 0]
[0, 0, 2, 0]
[1, 0, 2, 0]
[2, 0, 2, 0]
[0, 1, 2, 0]
[1, 1, 2, 0]
[2, 1, 2, 0]
[0, 2, 2, 0]
[1, 2, 2, 0]
[2, 2, 2, 0]
[0, 0, 0, 1]
[1, 0, 0, 1]
[2, 0, 0, 1]
[0, 1, 0, 1]
[1, 1, 0, 1]
[2, 1, 0, 1]
[0, 2, 0, 1]
[1, 2, 0, 1]
[2, 2, 0, 1]
[0, 0, 1, 1]
[1, 0, 1, 1]
[2, 0, 1, 1]
[0, 1, 1, 1]
[1, 1, 1, 1]
[2, 1, 1, 1]
[0, 2, 1, 1]
[1, 2, 1, 1]
[2, 2, 1, 1]
[0, 0, 2, 1]
[1, 0, 2, 1]
[2, 0, 2, 1]
[0, 1, 2, 1]
[1, 1, 2, 1]
[2, 1, 2, 1]
[0, 2, 2, 1]
[1, 2, 2, 1]
[2, 2, 2, 1]
[0, 0, 0, 2]
[1, 0, 0, 2]
[2, 0, 0, 2]
[0, 1, 0, 2]
[1, 1, 0, 2]
[2, 1, 0, 2]
[0, 2, 0, 2]
[1, 2, 0, 2]
[2, 2, 0, 2]
[0, 0, 1, 2]
[1, 0, 1, 2]
[2, 0, 1, 2]
[0, 1, 1, 2]
[1, 1, 1, 2]
[2, 1, 1, 2]
[0, 2, 1, 2]
[1, 2, 1, 2]
[2, 2, 1, 2]
[0, 0, 2, 2]
[1, 0, 2, 2]
[2, 0, 2, 2]
[0, 1, 2, 2]
[1, 1, 2, 2]
[2, 1, 2, 2]
[0, 2, 2, 2]
[1, 2, 2, 2]
[2, 2, 2, 2]


*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void printStrings(int n, int k, int [] A){
        if(n<=0){
            System.out.println(Arrays.toString(A));
        }else{
            for(int j=0;j<k;j++){
                A[n-1]=j;
                printStrings(n-1,k,A);
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the length of string: ");
		int len = scan.nextInt();
		int A[] = new int[len];
		System.out.println(len);
		System.out.print("Enter the variable values that can be taken: ");
		int k = scan.nextInt();
		scan.close();
		System.out.println(k);
		System.out.println("Total possible strings are: ");
		printStrings(len,k,A);
	}
}
