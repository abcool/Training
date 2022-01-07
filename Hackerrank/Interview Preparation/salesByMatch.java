import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

        public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        int no_of_pairs=0;
		
		//using HashSet
        Set<Integer> socks = new HashSet<>();
        for(Integer item: ar){
            if(socks.contains(item)){
                no_of_pairs++;
                socks.remove(item);
            }else{
                socks.add(item);
            }
        }
		
		//using HashMap
       /* Map<Integer,Integer> map = new HashMap<>();
        for(Integer i:ar){
            if((int)map.getOrDefault(i,0)==1){
                    no_of_pairs++;
                    map.replace(i,0);
                }else{
                    map.put(i,1);
                }
        }*/
        
        return no_of_pairs;
    }

}

public class salesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
