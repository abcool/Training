/*
Given an odd number in the form of string, 
the task is to make largest even number possible from the given number provided one is allowed to do only one swap operation, 
if no such number is possible then return the input string itself.

Input 1:
s = 4543
Output: 4534
Explanation: Swap 4(3rd pos) and 3.

Input 2:
s = 1539
Output: 1539
Explanation: No even no. present.
*/
public class OddToEven{
	 public static String makeEven(String s){
       char[] charArr = s.toCharArray();
       int evenNum = Integer.MAX_VALUE,index=-1;
       for(int i=0;i<charArr.length;i++){
           int left = Character.getNumericValue(charArr[i]);
           int right = Character.getNumericValue(charArr[charArr.length-1]);
           if(left%2==0){
               if(left<right){
                   evenNum = left;
                   index=i;
                   break;
               }else{
                   evenNum = left;
                   index=i;
               }
           }
       }
       if(index>=0){
           char temp = charArr[index];
           charArr[index] = charArr[charArr.length-1];
           charArr[charArr.length-1] = temp;
           return String.valueOf(charArr);
       }else{
           return s;
       }
    }
	public static void main(String[] abc){
		String s1 = "4543";
		System.out.println("Largest even number from "+ s1 + " with one swap is "+ makeEven(s1));
		String s2 = "1539";
		System.out.println("Largest even number from "+ s2 + " with one swap is "+ makeEven(s2));
	}
}