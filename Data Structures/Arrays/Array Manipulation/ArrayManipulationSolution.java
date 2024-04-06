import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayManipulationSolution {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long[] indexes = LongStream.range(0, n).map(i -> 0).toArray();

        for(List<Integer> op : queries) {
            for(int i = op.get(0) - 1; i < op.get(1) - 1; i++)
                indexes[i]+=op.get(2);
        }

        return Arrays.stream(indexes).max().getAsLong();
    }

    static long arrayManipulation_hackerrank1(int n, List<List<Integer>> queries) {
        long[] operationComputation = new long[n];

        for (int i = 0; i < queries.size(); i++) {
            int indexA = queries.get(i).get(0) - 1;
            int indexB = queries.get(i).get(1) - 1;
            int k = queries.get(i).get(2);

            operationComputation[indexA] += k;
            if (indexB + 1 < n ) {
                operationComputation[indexB + 1] -= k;
            }
        }

        long max = 0; long computation = 0;
        for (int i = 0; i < n; i++) {
            computation += operationComputation[i];
            max = Math.max(max, computation);
        }

        return max;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation_hackerrank(int n, int[][] queries) {
        long[] computation = new long[n];

        for (int i = 0; i < queries.length; i++) {
          int a = queries[i][0] - 1;
          int b = queries[i][1] - 1;
          int k = queries[i][2];

          computation[a] += k;
          if (b + 1 < n ) {
            computation[b + 1] -= k;
          }
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
          sum += computation[i];
          max = Math.max(max, sum);
        }

        return max;
  }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation_hackerrank1(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
