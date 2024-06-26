import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ResultFlippingMatrix {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here

        int matrixSize = matrix.size();
        int maxValue = 0;

        for (int i = 0; i < matrixSize / 2; i++) {
            for (int j = 0; j < matrixSize / 2; j++) {
                int currentMaxCell = matrix.get(i).get(j);
                currentMaxCell = Math.max(currentMaxCell,
                        matrix.get(i).get(matrixSize - j - 1));
                currentMaxCell = Math.max(currentMaxCell,
                        matrix.get(matrixSize - i - 1).get(matrixSize - j - 1));
                currentMaxCell = Math.max(currentMaxCell,
                        matrix.get(matrixSize - i - 1).get(j));

                maxValue += currentMaxCell;
            }

        }

        return maxValue;
    }

}

public class SolutionFlippingMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = ResultFlippingMatrix.flippingMatrix(matrix);

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