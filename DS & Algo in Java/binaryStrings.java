/*  
Generate all binary strings of n bits. Assume a[0...n-1] is an array of size n.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void permutations(int len, int[] a){
        if(len<=0){
            System.out.println(Arrays.toString(a));
        }else{
            a[len-1]=0;
            permutations(len-1,a);
            a[len-1]=1;
            permutations(len-1,a);
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	        Scanner scan = new Scanner(System.in);
	        System.out.print("Enter the length of string: ");
	        int len = scan.nextInt();
	        System.out.println(len);
	        scan.close();
	        int [] a = new int[len];
	        System.out.println("All possible strings are: ");
	        permutations(len,a);
	}
}
