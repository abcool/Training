/*
Given a number N, count the numbers from 1 to N which comprise of digits only from set {1, 2, 3, 4, 5}.

Example 1:

Input:
N = 20
Output: 10
Explanation: The numbers whose digits
are from the given set are:
1, 2, 3, 4, 5, 11, 12, 13, 14, 15.


Example 2:

Input:
N = 100
Output: 30
*/
public class DigitsInASet{
	private static boolean isNum(int num){
        while(num>0){
            int r= (num%10);
            if(r==0 || r>5)
                return false;
            num=num/10;
        }
        return true;
    }
    private static int countNumbers(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isNum(i))
                count++;
        }
        return count;
    }
	
	public static void main(String[] abc){
		int N=20;
		System.out.println("For N=" + N +" count="+countNumbers(N));
		N=100;
		System.out.println("For N=" + N +" count="+countNumbers(N));
	}
}