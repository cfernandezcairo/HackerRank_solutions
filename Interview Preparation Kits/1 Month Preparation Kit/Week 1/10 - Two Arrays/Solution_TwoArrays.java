import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_TwoArrays {

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays1(int k, List<Integer> A, List<Integer> B) {
        // Write your code here

        List<Integer> ASorted = A.stream().sorted().collect(Collectors.toList());
        List<Integer> BSorted = B.stream().sorted().collect(Collectors.toList());

        int size = ASorted.size();
        for (int i = 0; i < size; i++) {
            if (ASorted.get(i) + BSorted.get(size - (i+1)) < k)
                return "NO";
        }


        return "YES";

    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here

        List<Integer> ASorted = A.stream().sorted().collect(Collectors.toList());
        List<Integer> BSorted = B.stream().sorted().toList();
        List<Integer> BPermuted = new ArrayList<>();

        for (Integer aS : ASorted) {
            for (int i = BSorted.size() - 1; i >= 0; i--) {
                if(!BPermuted.contains(i)) {
                    Integer currentB = BSorted.get(i);
                    if (aS + currentB >= k) {
                        BPermuted.add(i);
                        break;
                    } else {
                        return "NO";
                    }
                }
            }
        }

        return "YES";
    }

}

public class Solution_TwoArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result_TwoArrays.twoArrays1(k, A, B);

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