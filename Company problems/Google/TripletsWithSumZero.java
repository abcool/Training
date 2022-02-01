/*
Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
Input : arr[] = {0, -1, 2, -3, 1}

Output : (0 -1 1), (2 -3 1)



Explanation : The triplets with zero sum are

0 + -1 + 1 = 0 and 2 + -3 + 1 = 0  



Input : arr[] = {1, -2, 1, 0, 5}

Output : 1 -2  1

Explanation : The triplets with zero sum is

1 + -2 + 1 = 0

Algorithm: 

1. Sort the array in ascending order.
2. Traverse the array from start to end.
3. For every index i, 
		create two variables l = i + 1 and r = n - 1
4. Run a loop until l is less than r 
	If the sum of array[i], array[l] and array[r] is equal to zero then 
		print the triplet and break the loop
    If the sum is less than zero then 
		increment the value of l, by increasing the value of l the sum will increase as the array is sorted, so array[l+1] > array [l]
	If the sum is greater than zero then 
		decrement the value of r, by increasing the value of l the sum will decrease as the array is sorted, so array[r-1] < array [r].
*/
import java.util.Arrays;
class TripletsWithSumZero{
	private static void findTriplets(int arr[] , int n){
		boolean found = false;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int sum = arr[i]+arr[l]+arr[r];
                if(sum==0){
					found=true;
                    System.out.println("(" + arr[i]+","+arr[l]+","+arr[r]+")");
					//find next triplet
                    l++;
                    r--;
				}else if(arr[i]+arr[l]+arr[r]<0){
					l++;
				}else{
					r--;
				}
            }
        }
		if(!found)
			System.out.println("No triplets found");
    }
	public static void main(String[] ar){
		int[] a1 = {0, -1, 2, -3, 1};
		int[] a2 = {1, -2, 1, 0, 5};
		int[] a3 = {1,2,3};
		System.out.println("Triplets for a1 " + "are");
		findTriplets(a1,a1.length);
		System.out.println("Triplets for a2 "+ "are");
		findTriplets(a2,a2.length);
		System.out.println("Triplets for a3 "+ "are");
		findTriplets(a3,a3.length);
	}
}