import java.util.*;
import java.lang.*;
import java.io.*;

/** @author: Arvind Bakshi
Given a string, S, of length N that is indexed from 0 to N-1, 
print its even-indexed and odd-indexed characters as 2
space-separated strings on a single line (see the Sample below for more detail).

Note: 0 is considered to be an even index.  **/
class Codechef
{
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.skip("\n");
        while(count>0){
        String input = scan.nextLine();
        String output[] = new String[]{"",""};
        for(int i=0;i<input.length(); i++){
            if(i%2==0){
            output[0]+=input.charAt(i);
            }else{
            output[1]+=input.charAt(i);
            }
        }
        System.out.println(output[0] + " " + output[1]);
        count--;
        }
        scan.close();
    }
}
