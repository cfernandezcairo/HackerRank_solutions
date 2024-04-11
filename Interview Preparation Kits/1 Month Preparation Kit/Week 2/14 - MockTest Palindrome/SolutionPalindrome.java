import java.io.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class ResultPalindrome {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        // Write your code here

        int outputIndex = -1;
        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {

                if (i + 1 < len) {
                    boolean isRightSubStringPalindrome = isPalindrome(s.substring(i + 1, len - i));
                    if (isRightSubStringPalindrome)
                        return i;
                    return len - i - 1;
                }
            }
        }

        return outputIndex;

    }

}

public class SolutionPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultPalindrome.palindromeIndex(s);

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