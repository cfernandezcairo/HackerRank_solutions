import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class ResultAnagram {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        // Write your code here

        int len = s.length();
        if(len%2 != 0)
            return -1;

        int count = 0;
        for(int i = 0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) {
                count++;
            }
        }

        return count;

    }

    static int anagram_AlexPrut(String s){
        if (s.length() % 2 != 0) { return -1; }
        int[] cache = new int[70];

        //Set mark for all character occurrences
        for (int i = 0; i < s.length() / 2; i++) {
            cache[Character.getNumericValue(s.charAt(i))]++;
        }

        //Unset mark for all character occurrences in the previous for (discard all commun characters)
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (cache[Character.getNumericValue(s.charAt(i))] > 0) {
                cache[Character.getNumericValue(s.charAt(i))]--;
            }
        }

        //count all uncommunt characters (it is a number of operations)
        int counter = 0;
        for (int i = 0; i < 70; i++) {
            counter += cache[i];
        }

        return counter;
    }

}

public class SolutionAnagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultAnagram.anagram_AlexPrut(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}