/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
   static double withdrawlAmount,balance,charges=0.50;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		withdrawlAmount= scan.nextDouble();
		//System.out.println("withdrawlAmount= " + withdrawlAmount);
		balance = scan.nextDouble();
		//System.out.println("balance= " + balance);
		scan.close();
		if((withdrawlAmount % 5) ==0 && (balance > withdrawlAmount)){
		    balance = balance - withdrawlAmount - charges;
		    System.out.println(String.format("%.2f",balance));
		}else{
		    System.out.println(String.format("%.2f",balance));
		}
		
	}
}
