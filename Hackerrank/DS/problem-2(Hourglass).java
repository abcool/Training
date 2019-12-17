import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int finalSum=-200;
        for(int r=0;r<4;r++){ // scan row wise fro 0 to 3
            int sum=0;
            for(int c=0;c<4;c++){ // for each row, calculate hourglass from column 0 to 3
                sum+=arr[r][c]+arr[r][c+1]+arr[r][c+2]
                              +arr[r+1][c+1]
                    +arr[r+2][c]+arr[r+2][c+1]+arr[r+2][c+2];
                System.out.println(r + c +" "+ r +(c+1)+" "+r+(c+2)
                                   +"\n"+(r+1) +(c+1)+"\n"
                                   +(r+2) + c +" "+ (r+2) + (c+1) +" " + (r+2) +(c+2)                                       +"\n"+sum);
                if(finalSum<sum)finalSum=sum;
                sum=0;
            }
            
        }
        return finalSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
