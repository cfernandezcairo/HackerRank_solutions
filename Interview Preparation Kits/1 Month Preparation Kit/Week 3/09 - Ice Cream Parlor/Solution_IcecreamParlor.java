import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_IcecreamParlor {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    private static int getFlavorIndex(int n, List<Integer> subArr) {
        return subArr.indexOf(n);
    }
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            int secondFlavor = getFlavorIndex(m - arr.get(i), arr.subList(i+1, arr.size()));

            if(secondFlavor != -1) {
                result.add(i+1);
                result.add((i+1)+(secondFlavor+1));
                break;
            }
        }
        return result;
    }

}

public class Solution_IcecreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result_IcecreamParlor.icecreamParlor(m, arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}