// github.com/RodneyShag

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SeparateNumbers_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    static String beauty(int left, String expStr) {
        int expInt = left+1;
        if(expStr.isEmpty())
            return "";
        else
            if(expStr.startsWith(String.valueOf(expInt))) {
                return expInt + beauty(expInt, expStr.replaceFirst(String.valueOf(expInt), ""));
            } else {
                return expStr;
            }
    }
    public static void separateNumbers(String s) {
        // Write your code here

        if(s.length() <= 1 || s.charAt(0) == '0') {
            System.out.println("NO");
        } else {

            for(int i = 1; i <= s.length()/2; i++) {
                long startPoint = Long.valueOf(s.substring(0, i));
                long incrementPoint = startPoint;
                String current = String.valueOf(startPoint);

                while (current.length() < s.length()) {
                    incrementPoint+=1;
                    current+=String.valueOf(incrementPoint);
                }

                if(current.equals(s)) {
                    System.out.println("YES " + startPoint);
                    return;
                }
            }
            System.out.println("NO");
        }
    }

}

// Discuss on HackerRank: https://www.hackerrank.com/challenges/caesar-cipher-1/forum/comments/269393
