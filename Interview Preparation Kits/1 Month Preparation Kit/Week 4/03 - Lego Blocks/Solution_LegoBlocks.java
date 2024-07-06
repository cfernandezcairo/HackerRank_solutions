import java.io.*;
import java.util.Arrays;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;


class Result_Medium_LegoBlocks {

    // - Step 1: consider only one row
    // - Step 2: extend to all rows
    // - Step 3: subtract the vertically unstable
    // The unstable is calculated by summing each stable*total
    // or calculate the result immediately by summing each result*total

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     *  1. INTEGER n - height
     *  2. INTEGER m - width
     */

    public static int legoBlocks(int n, int m) {
        // Write your code here
        if (n < 2 || m < 1) return 0;
        if (m == 1) return 1;

        // - Step 1: consider only one row
        long [] total = new long [m + 1];

        // set a flag (-1) to calculate only once
        for (int i = 0; i < total.length; i++)
            total[i] = -1;

        fillTot(total, m);

        // - Step 2: extend to all rows
        for (int i = 0; i < total.length; i++) {
            long tmp = 1;
            for (int j = 0; j < n; j++) {
                tmp = (tmp * total[i]) % MOD;
            }
            total[i] = tmp;
        }

        // - Step 3: subtract the vertically unstable
        // don't calculate the vertically unstable at first
        long [] result = new long [m + 1];
        // set a flag (-1) to calculate only once
        for (int i = 0; i < result.length; i++)
            result[i] = -1;

        getResult(total, result, m);

        // solution 1:
        // - subtract the vertically unstable
        // return (int) ((total[m] - result[m]) % MOD);

        // solution 2:
        // - return the result
        return (int) (result[m] % MOD);
    }

    static long MOD = 1000000000 + 7;

    // calculate unstable by splitting it into two parts and
    // multiplying unstable part with total part
    static long getResult(long [] total, long [] result, int i) {
        if (result[i] == -1) {
            if (i == 1) {
                // solution 1
                // result[i] = 0;

                // solution 2
                result[i] = 1;
            }
            else {
                // solution 1
                // result[i] = 0;
                // for (int j = 1; j < i; j++) {
                //     result[i] += ((total[j] - getResult(total, result, j)) * total[i - j]) % MOD;
                // }

                // solution 2
                result[i] = total[i];
                for (int j = 1; j < i; j++) {
                    result[i] -= (getResult(total, result, j) * total[i - j]) % MOD;
                }
            }
        }

        return result[i];
    }

    // fill totals partially
    static long fillTot(long [] total, int i) {
        if (i < 0) return 0;

        if (total[i] == -1) {
            if (i == 0 || i == 1)
                total[i] = 1;
            else
                total[i] = (fillTot(total, i - 1) + fillTot(total, i - 2) + fillTot(total, i - 3) + fillTot(total, i - 4)) % MOD;
        }

        return total[i];
    }

}

class Result_LegoBlocks {

    // - Step 1: consider only one row
    // - Step 2: extend to all rows
    // - Step 3: subtract the vertically unstable
    // The unstable is calculated by summing each stable*total
    // or calculate the result immediately by summing each result*total

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     *  1. INTEGER n - height
     *  2. INTEGER m - width
     */


    public static int legoBlocks(int h, int w) {
        // Write your code here
        long modulo = 1000000000 + 7;

        // - Step 1: consider only one row
        long [] row = IntStream.range(0, w + 1).mapToLong(i -> 0).toArray();

        if(w>=1) row[1] = 1;
        if(w>=2) row[2] = 2;
        if(w>=3) row[3] = 4;
        if(w>=4) row[4] = 8;
        if(w>=5) IntStream.range(5, (w + 1)).forEach(i -> row[i] = (row[i - 1] + row[i - 2] + row[i - 3] + row[i - 4]) % modulo);

        // - Step 2: consider only one h rows
        long [] totalLayout = Arrays.stream(row).toArray();
        IntStream.range(2, h + 1).flatMap(i -> IntStream.range(1, w + 1)).forEach(j -> totalLayout[j] = (row[j] * totalLayout[j]) % modulo);

        // - Step 3: Detect solid layouts (total - unsolid)
        long [] solidLayout = IntStream.range(0, w + 1).mapToLong(i -> 0).toArray();
        solidLayout[1] = 1;
        for(int ww = 2; ww < w+1; ww++) {

            // Uw = Sum (i=1 to w-1) [Si * Tw-i]
            int unsolidLayoutSum = 0;
            for(int i = 1; i < ww; i++) {
                unsolidLayoutSum += ((solidLayout[i] * totalLayout[ww - i]) % modulo);
            }

            // Sw = Tw - Uw
            solidLayout[ww] = (totalLayout[ww] - unsolidLayoutSum) % modulo;

        }

        return Math.toIntExact(solidLayout[w] % modulo);
    }

}

public class Solution_LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result_LegoBlocks.legoBlocks(n, m);

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