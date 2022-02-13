/*
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome

Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome

-----------------------------------------------

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)


Constraints:
1 <= Length of S<= 105
*/
public class Palindrome{
	private static int isPalindrome(String S) {
        int s=0,e=S.length()-1;
        while(s<e){
            if(S.charAt(s)!=S.charAt(e))
                return 0;
            s++;e--;
        }
        return 1;
    }
	public static void main(String[] h){
		String s1 ="abba",s2="aba";
		System.out.println("String \""+ s1 + "\" is palindrome? (1- yes, 0- No) " + isPalindrome(s1));
		System.out.println("String \""+ s2 + "\" is palindrome? (1- yes, 0- No) " + isPalindrome(s2));
	}
}