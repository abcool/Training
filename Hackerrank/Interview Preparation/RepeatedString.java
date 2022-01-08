import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
     // s= aba, 3 , returns 2
     // s= aba, 1, returns 1
    private static long A_in_S(String s, long strLength){
        long c = 0;
           for(int i=0;i<strLength;i++){
               if(s.charAt(i)=='a'){
                   c++;
               }
           }
           return c;
    }
    
    // Algorithm
    /* count = (full repetation of string s * number of a's in s) +
      (number of a's in substring of s that will make total length n)
    */
    // s= aba, n= 10
    // s= abcac, n = 10
    public static long repeatedString(String s, long n) {
       int sLength = s.length();//3 // 5
       long fullRepeat = n/sLength; // 10/3 = 3  // 10/5 = 2
       long half = n%sLength; // 10 % 3 = 1  // 0
       long stringLeft = (half==0)?0:half; // 1 // 0
       long count = fullRepeat * A_in_S(s,s.length()) + A_in_S(s,stringLeft);// 3 * 2 + 1 // 2 * 2
       return count; // 7 // 4
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
