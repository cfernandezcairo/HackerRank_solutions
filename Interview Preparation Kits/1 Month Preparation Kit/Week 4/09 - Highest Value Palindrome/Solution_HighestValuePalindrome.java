import java.io.*;
import java.util.stream.*;


class Result_HighestValuePalindrome {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    private static String highestValuePalindromeRecursiveNextCall(String left, String prevS, String right, int k) {
        String middle = "";
        int currentN = 0;
        if(prevS.length() > 2) {
            middle = prevS.substring(1, prevS.length()-1);
            currentN = prevS.length()-2;
        }

        return (new StringBuffer().
                append(left).
                append(highestValuePalindromeRecursive(middle, currentN, k)).
                append(right)).toString();
    }

    private static String highestValuePalindromeRecursive(String s, int n, int k) {
        // Write your code here

        if(n == 0) {
            /*if(k < 0)
                return "-1";
            else*/
                return "";
        }

        int [] sInt = IntStream.range(0, n).map(i -> Character.getNumericValue(s.charAt(i))).toArray();
        for(int i = 9; i >= sInt[0]; i--) {
            if(sInt[0] == sInt[n-1]) {
                if(n >= 2) {
                    if(k > 2) {
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(i), s, String.valueOf(i), k-2);
                    } else {
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(sInt[0]), s, String.valueOf(sInt[0]), k);
                    }
                } else {
                    if(k > 0)
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(i), s, "", k-1);
                    else {
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(sInt[0]), s, "", k);
                    }
                }
            } else {
                if(n >= 2) {
                    if(k > 2) {
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(i), s, String.valueOf(i), k-2);
                    } else {
                        //return "-1";
                    }
                } else {
                    if(k > 0)
                        return highestValuePalindromeRecursiveNextCall(String.valueOf(Math.max(sInt[0], sInt[n-1])), s, String.valueOf(Math.max(sInt[0], sInt[n-1])), k-1);
                    else {
                        return "-1";
                    }
                }
            }
        }

        return "";
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        String result = highestValuePalindromeRecursive(s, n, k);
        return result.contains("-1") ? "-1" : result;
    }

}

public class Solution_HighestValuePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result_HighestValuePalindrome.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}