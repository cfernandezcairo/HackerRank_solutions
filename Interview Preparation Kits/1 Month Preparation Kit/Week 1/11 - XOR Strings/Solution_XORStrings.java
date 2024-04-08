import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_XORStrings {

    public static String strings_xor(String s1, String s2) {
        // Write your code here

        char[] result = new char[s1.length()];

        for(int i = 0; i < s1.length(); i++) {
            result[i] = (s1.charAt(i) == s2.charAt(i)) ? '0' : '1';
        }

        return String.valueOf(result);
    }

}

public class Solution_XORStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine().trim();
        String s2 = bufferedReader.readLine().trim();



        String result = Result_XORStrings.strings_xor(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}