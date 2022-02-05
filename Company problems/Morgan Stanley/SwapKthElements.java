public class SwapKthElements{
	
	private static void swapKth(int arr[], int n, int k) {
        int temp=arr[k-1];
        arr[k-1]=arr[n-k];
        arr[n-k]=temp;
		for(int i=0;i<arr.length;i++)
				System.out.print(arr[i]);
    }
	
	public static void main(String[] dc){
		int[] a={1, 2, 3, 4, 5, 6, 7, 8};
		int[] b = {5, 3, 6, 1, 2};
		System.out.println("Original Array: ");
		for(int i=0;i<a.length;i++)
				System.out.print(a[i]);
		int k=3;
		System.out.println("\n After swapping "+ k +" element from beginning with "+ k + " element from end");
		swapKth(a,a.length,k);
		System.out.println("\n Original Array: ");
		for(int i=0;i<b.length;i++)
				System.out.print(b[i]);
		k=2;
		System.out.println("\n After swapping "+ k +" element from beginning with "+ k + " element from end");
		swapKth(b,b.length,k);
	}
}