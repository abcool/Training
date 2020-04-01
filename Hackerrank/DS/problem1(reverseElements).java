/* Program to reverse elements of an array */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[]={1,2,3,4};
		int len=a.length;
		for(int i=0;i<len/2;i++){
		    int temp;
		    temp=a[len-1-i];
		    a[len-1-i]=a[i];
		    a[i]=temp;
		}
		for(int i=0;i<len;i++){
		System.out.print(a[i] + " ");
		}
	}
}
