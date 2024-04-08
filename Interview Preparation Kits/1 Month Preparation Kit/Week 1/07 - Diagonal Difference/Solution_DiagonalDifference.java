import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference_cfernandezcairo(List<List<Integer>> arr) {
        // Write your code here
        Integer sumLeftD = 0;
        Integer sumRightD = 0;

        int i = 0;
        for(List<Integer> l : arr) {
            sumLeftD += l.get(i);
            sumRightD += l.get(l.size() - (i+1));

            i++;
        }

        return Math.abs(sumLeftD-sumRightD);
    }

    public static int diagonalDifference_tom_miller597(List<List<Integer>> arr) {
        // Write your code here
        int downwardDiagonal = 0;
        int upwardDiagonal = 0;

        int dimension = arr.size();

        for (int i = 0; i < dimension; i++) {
            List<Integer> row = arr.get(i);

            downwardDiagonal += row.get(i);
            upwardDiagonal += row.get(dimension - 1 - i);
        }

        return Math.abs(downwardDiagonal - upwardDiagonal);

    }

}

public class Solution_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result_DiagonalDifference.diagonalDifference_cfernandezcairo(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}