// github.com/RodneyShag

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CommonChild_Result {

    static int commonChild1(String s1, String s2) {
        return LCSM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());

    }

    public static int LCSM4(char[] X, char[] Y, int m, int n) {
        int memo[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

        }
        for(int i : memo)
            System.out.print(memo[i] + "---");
        System.out.println();
        return memo[n];
    }

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
        /*int start = 0;
        int s1_end = s1.length();
        int s2_end = s2.length();*/

        /*//trim off the matching items at the beginning
        while (start <= s1_end && start <= s2_end && s1.charAt(start) == s2.charAt(start))
            start++;

        //trim off the matching items at the end
        while (start <= s1_end && start <= s2_end && s1.charAt(s1_end) == s2.charAt(s2_end)) {
            s1_end--;
            s2_end--;
        }*/

        Integer[][] C = IntStream.range(0, s1.length()+1)
                .mapToObj(rowArray -> IntStream.range(0, s2.length()+1)
                        .mapToObj(columnArrayElement -> 0)
                        .toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    C[i][j] = C[i-1][j-1]+1;
                else
                    C[i][j] = Math.max(C[i][j-1], C[i-1][j]);
            }
        }

        return C[s1.length()][s2.length()];
    }

    public static int commonChild_try(String s1, String s2) {
        // Write your code here

        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();

        int maxLenght = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        if(s1Length != s2Length)
            return 0;

        NEXT_I:
        for (int i = 0; i + maxLenght < s1Length; i++) {
            int currentMaxLenght = 0;
            int lastMatchIndex = 0;
            int currentI = i;

            Map<Integer, Integer> tmpMem = new HashMap<>();
            while (currentI < s2Length) {
                int find = s2.indexOf(s1.charAt(currentI), lastMatchIndex);
                if(find != -1) {
                    tmpMem.put(currentI, find);
                    lastMatchIndex = find + 1;
                    currentMaxLenght++;
                } else if (lastMatchIndex == s2Length) {
                    break;
                }
                currentI++;
                //if(lastMatchIndex + (maxLenght - currentMaxLenght) > s2Length)
                //    continue NEXT_I;
            }

            Map<Integer, Integer> result = tmpMem.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, HashMap::new));

            mem.put(currentMaxLenght, result);
            if (maxLenght < currentMaxLenght)
                maxLenght = currentMaxLenght;

        }

        System.out.println(mem);
        return maxLenght;
    }

}

public class CommonChild_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = CommonChild_Result.commonChild(s1, s2);
        int result1 = CommonChild_Result.commonChild1(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.write(String.valueOf(result1));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
