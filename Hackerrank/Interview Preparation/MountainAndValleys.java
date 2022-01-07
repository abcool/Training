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
     * 
_/\      _
   \    /
    \/\/
  
		   
sea level      sea level prev
		  0    0
		  1    0
		  0    1
		 -1    0
		 -2   -1
		 -1   -2
		 -2   -1
		 -1   -2
		  0   -1
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        int seaLevel=0,prevSeaLevel=0;
        int valleyCount=0,mountainCount=0;
        for(int i=0;i<steps;i++){
            if(path.charAt(i)=='D'){
                prevSeaLevel=seaLevel;
                seaLevel--;
            }
            if(path.charAt(i)=='U'){
                prevSeaLevel=seaLevel;
                seaLevel++;
            }
            if(seaLevel==0){
                if(prevSeaLevel<0)
                    valleyCount++;
                if(prevSeaLevel>0)
                    mountainCount++;
            }
        }
        return valleyCount;
    }

}

public class MountainAndValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
