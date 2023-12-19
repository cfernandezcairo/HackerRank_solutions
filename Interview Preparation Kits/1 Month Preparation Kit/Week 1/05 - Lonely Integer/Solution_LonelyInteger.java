import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_LonelyInteger {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger_cfernandezcairo(List<Integer> a) {
        // Write your code here
        List<Integer> uElementL = new ArrayList<>();
        List<Integer> uList = new ArrayList<>();

        a.forEach(c -> {
            if (!uList.contains(c)) {
                uElementL.add(c);
                uList.add(c);
            } else {
                uElementL.remove(c);
            }
        });

        return uElementL.get(0).intValue();
    }

    public static int lonelyinteger_tom_miller597(List<Integer> a) {
        // Write your code here
        int result = 0;

        for (Integer num : a) {
            if (a.stream().filter(value -> value == num).count() == 1L) {
                result = num;
                break;
            }
        }

        return result;

    }

}

public class Solution_LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_LonelyInteger.lonelyinteger_cfernandezcairo(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}