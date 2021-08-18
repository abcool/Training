// Hackerrank problem: https://www.hackerrank.com/challenges/java-string-compare/problem
import java.util.Scanner;

public class Test {

    public static int returnSmaller(String s1, String s2){
        char [] ch1 = s1.toCharArray();
        char [] ch2 = s2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]<ch2[i]){
                return 1;
            }
            if(ch2[i]<ch1[i]){
                return 2;
            }
        }
        return 0;
    }
    public static String[] lexigraphicOrderedStrings(int n,String s){
        String [] stringArr = new String[s.length()-n+1];
        //int length = s.length();
        int k=0;
        for(int i=0;i<s.length()-n+1;i++){
            String str="";
            for(int j=i;j<i+n;j++){
                str+=s.charAt(j);
            }
            stringArr[k]=str;
            k++;
        }

        for(int i=0;i<stringArr.length-1;i++){
            //String st = stringArr[i];
            for(int j=i+1;j<stringArr.length;j++){
                int result = returnSmaller(stringArr[i],stringArr[j]);
                if(result==2){
                    String temp = stringArr[i];
                    stringArr[i]=stringArr[j];
                    stringArr[j] = temp;
                }
            }
        }
        return stringArr;
    }
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String [] lexiographicOrderedSubStrings = lexigraphicOrderedStrings(k,s);
        smallest = lexiographicOrderedSubStrings[0];
        largest = lexiographicOrderedSubStrings[lexiographicOrderedSubStrings.length-1];
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}