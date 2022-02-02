public class PeakElement{
private static int peakElement(int[] arr,int n)
    {
       /*for(int i=0;i<n;i++){
           int left=i-1,right=i+1;
           if(left<0)
            left=0;
           if(right>n-1)
             right=n-1;
           if(arr[i]>=arr[right] && arr[i]>=arr[left])
             return i;
       }
       return 0;*/
       int left=0,right=n-1,middle=0;
       while(left<=right){
           middle = left + (right-left)/2;
           if((middle==0 || arr[middle]>=arr[middle-1])
           && (middle==n-1 || arr[middle]>=arr[middle+1])){
               break;
           }
           if(middle>0 && arr[middle]<arr[middle-1])
                right=middle-1;
           else
             left = middle+1;
       }
       return middle;
    }
  public static void main(String[] a){
    int[] input1 = {1,2,3};
    System.out.println("Index of first peak element is: "+ peakElement(a,a.length));
  }
}
