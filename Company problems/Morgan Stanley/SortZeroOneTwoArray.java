/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.
----------------------------------------------------------------------------

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2
*/
public class SortZeroOneTwoArray{
	
	private static void sort012(int a[], int n)
    {
        int zero=0,one=0,two=0;
        for(int i=0;i<n;i++){
            switch(a[i]){
                case 0:
                    zero++;break;
                case 1:
                    one++;break;
                case 2:
                    two++;break;
            }
        }
        int i=0;
        while(zero>0){
            a[i]=0;
            i++;
            zero--;
        }
        while(one>0){
           a[i]=1;
            i++;
            one--; 
        }
        while(two>0){
           a[i]=2;
            i++;
            two--; 
        }
    }
	public static void main(String[] abc){
		int[] a1 ={0, 2, 1, 2, 0};
		int[] a2 ={0, 1, 0};
		System.out.println("Before sorting a1: ");
		for(int i:a1)
			System.out.print(i+" ");
		sort012(a1,a1.length);
		System.out.println("\n After sorting a1: ");
		for(int i:a1)
			System.out.print(i+" ");
		System.out.println("\n Before sorting a2: ");
		for(int i:a2)
			System.out.print(i+" ");
		sort012(a2,a2.length);
		System.out.println("\n After sorting a2: ");
		for(int i:a2)
			System.out.print(i+" ");
	}
}