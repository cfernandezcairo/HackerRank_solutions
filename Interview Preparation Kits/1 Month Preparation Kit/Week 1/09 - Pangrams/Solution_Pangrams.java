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

class Result_Pangrams {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams_cfernandezcairo(String s) {
        // Write your code here

        String[] alphabet = new String[]{
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };
        Set<String> pangramTracker = new HashSet<>(Arrays.asList(alphabet));

        for(char ch : s.toCharArray()) {
            String currentCh = String.valueOf(ch).toUpperCase();
            if(pangramTracker.contains(currentCh))
                pangramTracker.remove(currentCh);
        }
        return pangramTracker.size() == 0 ? "pangram" : "not pangram";
    }

}

public class Solution_Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result_Pangrams.pangrams_cfernandezcairo(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}