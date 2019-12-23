import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] q) {
        long sums[] = new long[n+1];
        for (int i = 0; i < q.length; i++) {
            sums[q[i][0] - 1] += (long)q[i][2];
            if (q[i][1] <= n) {
                sums[q[i][1]] -= (long)q[i][2];
            }
        }
        long max = Long.MIN_VALUE;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += (long)sums[i];
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
