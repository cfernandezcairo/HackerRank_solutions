import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result_ArrayManipulation {

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


}

public class Solution_ArrayManipulation {
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

        long result = Result_ArrayManipulation.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}