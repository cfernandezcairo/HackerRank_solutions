import scala.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class ResultCaesarCipher {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        Character[] alphabet = new Character[]{
                'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e',
                'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j',
                'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
                'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
                'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'
        };
        List<Character> alp = new ArrayList<>(List.of(alphabet));
        
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()) {
            
            //Encrypt function code
            if(alp.contains(c)) {
                result.append(alphabet[(alp.indexOf(c) + (k * 2)) % alp.size()]);
            } else {
                result.append(c);
            }
            
        }
        
        return result.toString();
    }

    public static String caesarCipher_HR(String s, int k) {
        // Write your code here
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result.append(encrypt(ch, k));
        }
        return result.toString();
    }

    private static char encrypt(char ch, int K) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch - base + K) % 26 + base);
    }

}

public class SolutionCaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = ResultCaesarCipher.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}