// github.com/RodneyShag

import java.io.*;
import java.util.stream.IntStream;

class PalindromeIndex_Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here

        //FirstCheck
        StringBuilder palindromeCandidate = new StringBuilder(s);
        if(s.equals(palindromeCandidate.reverse().toString()))
            return -1;
        else
            palindromeCandidate.reverse();

        int sPalindromeResult = -1;
        for(int i = 0; i < s.length(); i++) {
            palindromeCandidate.deleteCharAt(i);  // Shift the positions front.

            if(palindromeCandidate.toString().equals(palindromeCandidate.reverse().toString())) {
                sPalindromeResult = i;
                break;
            }

            palindromeCandidate.reverse();
            palindromeCandidate.insert(i, s.charAt(i));
        }

        return sPalindromeResult;

    }

    public static int palindromeIndex2(String s) {
        // Write your code here

        char[] sChar = s.toCharArray();
        int length = sChar.length;
        int result = -1;
        for(int i = 0, j = length - 1; i + j < length && i <= j; ){
            if(i == j) {
                if(sChar[i] != sChar[j-1])
                    result = i;
                break;
            } else if (j - i == 1) {
                if(sChar[i] == sChar[j]) {
                    break;
                } else if (sChar[i] == sChar[j+1]) {
                    result = j;
                    break;
                } else {
                    result = i;
                    break;
                }
            } else if(sChar[i] == sChar[j]) {
                i++;
                j--;
            } else if (sChar[i] == sChar[j-1]) {
                result = j;
                break;
            } else if (sChar[i + 1] == sChar[j]) {
                result = i;
                break;
            } else {
                break;
            }
        }
        return result;
    }

    public static int palindromeIndex3(String s) {
        // Write your code here

        int outputIndex = -1;
        boolean remove = false;

        for(int i = 0, j = s.length()-1; i < j; i++, j--) {

            if(s.charAt(i) != s.charAt(j)) {

                if(remove) {
                    outputIndex = -1;
                    break;
                }

                if(j - i > 1) {

                    if(s.charAt(i+1) == s.charAt(j)) {
                        remove = true;
                        outputIndex = i;
                        i++;
                    }
                    else if(s.charAt(i) == s.charAt(j-1)) {
                        remove = true;
                        outputIndex = j;
                        j--;
                    }
                    else {
                        remove = false;
                        outputIndex = -1;
                        break;
                    }

                } else {

                    if(s.charAt(i-1) == s.charAt(j)) {
                        remove = true;
                        outputIndex = i;
                        i++;
                    }
                    else if(s.charAt(i) == s.charAt(j+1)) {
                        remove = true;
                        outputIndex = j;
                        j--;
                    }

                }

            }
        }

        return outputIndex;

    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int palindromeIndex4(String s) {
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

public class PalindromeIndex_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = PalindromeIndex_Result.palindromeIndex3(s);

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
