/* Credit sussie problem 1 
Program to remove \n with newline, \b with backspace in a string containing \n and \b

Sample Input:
this is new\b \nline for testing
this is\b also another \nnew line

Sample Output:
this is new
line for testing
this isalso another 
new line

*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
		    String name = scan.nextLine();
		    char[] out = name.toCharArray();
		    for(int i=0;i<out.length;i++){
		        if(out[i]=='\\' && out[i+1]=='n'){
		            System.out.println();
		            i++;
		            continue;
		        }
		        if(out[i]=='\\' && out[i+1]=='b'){
		            out[i-1]=out[i+2];
		            i=i+2;
		            continue;
		        }
		        System.out.print(out[i]);
		    }
		    System.out.println();
		}
		scan.close();
	}
}
