// github.com/RodneyShag

import java.util.List;
import java.util.Scanner;

public class RepeatedString_Solution {

    static long repeatedString(String str, long n) {
        /* Found out # of times 'a' appears in our String */
        int wordAs = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                wordAs++;
            }
        }

        long completeWords    = n / str.length();
        long remainingLetters = n % str.length();
        long totalAs          = completeWords * wordAs;

        /* Count up the remaining 'a' characters */
        for (int i = 0; i < remainingLetters; i++) {
            if (str.charAt(i) == 'a') {
                totalAs++;
            }
        }

        return totalAs;
    }


    public static void main(String[] args) {
        /* Save input */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] cloud = new int[n];
        for (int i = 0; i < n; i++) {
            cloud[i] = scan.nextInt();
        }
        scan.close();

    }
}

// Discuss on HackerRank: https://www.hackerrank.com/challenges/repeated-string/forum/comments/266320
