import scala.runtime.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultDynamicArray {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> answerArray = new ArrayList<>();

        List<List<Integer>> queryArray = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            queryArray.add(new ArrayList<>());
        }

        Integer lastAnswer = 0;
        for(List<Integer> q : queries) {
            int x = q.get(1);
            int y = q.get(2);
            int idx = (x ^ lastAnswer) % n;

            switch (q.get(0)) {
                case 1:
                    queryArray.get(idx).add(y);
                    break;
                case 2:
                    lastAnswer = queryArray.get(idx).get(y % queryArray.get(idx).size());
                    answerArray.add(lastAnswer);
                    break;
            }
        }

        return answerArray;

    }

}

public class SolutionDynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
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

        List<Integer> result = ResultDynamicArray.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}