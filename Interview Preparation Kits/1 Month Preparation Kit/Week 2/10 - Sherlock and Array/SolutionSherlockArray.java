import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SolutionSherlockArray {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        if(arr.size() == 1)
            return "YES";

        long sumLeft = 0, sumRight = 0;
        int i = -1, j = arr.size();
        for(; j - i > 2; ) {
            if((sumLeft == sumRight)) {
                sumLeft+=arr.get(++i);
                sumRight+=arr.get(--j);
            } else if (sumLeft < arr.get(j-1)) {
                sumLeft+=arr.get(++i);
            } else {
                sumRight+=arr.get(--j);
            }
        }

        if(sumLeft == sumRight && j - i == 2)
            return "YES";
        else
            return "NO";

    }

    public static String balancedSums1(List<Integer> arr) {
        // Write your code here
        /*if(arr.size() == 1)
            return "YES";*/

        int n = arr.size();
        int[] sumarizeLeft = new int[n+2];
        int[] sumarizeRight = new int[n+2];

        sumarizeLeft[0] = sumarizeLeft[n-1] = sumarizeRight[0] = sumarizeRight[n-1] = 0;

        int sumL = 0, sumR = 0;
        for(int i = 0; i < n; i++) {
            sumL+=arr.get(i);
            sumR+=arr.get(n-i-1);

            sumarizeLeft[i + 1] = sumL;
            sumarizeRight[(n-i-1) + 1] = sumR;
        }

        for(int i = 0, j = n + 2 - 1; i <= j;) {
            if(sumarizeLeft[i] == sumarizeRight[j]) {
                if((i == j || i+2 == j)) {
                    return "YES";
                } else {
                    i++;
                    j--;
                }
            } else if (sumarizeLeft[i] < sumarizeRight[j]) {
                i++;
            } else {
                j--;
            }
        }

        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums1(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}