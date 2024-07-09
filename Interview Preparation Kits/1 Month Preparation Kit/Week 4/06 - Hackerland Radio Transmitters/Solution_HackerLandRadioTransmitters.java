import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result_HackerLandRadioTransmitters {

    /*
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     */

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        // Write your code here

        x.sort(Comparator.naturalOrder());

        int count = 0;
        int i = 0;
        while (i < x.size()) {
            count++;

            int start = i;

            while((i + 1 < x.size()) && (x.get(i + 1) - x.get(start) <= k)) { i++; }
            int middle = i;

            //search end house
            while((i + 1 < x.size()) && (x.get(i + 1) - x.get(middle) <= k)) { i++; }

            i++;
        }

        return count;

    }


}

public class Solution_HackerLandRadioTransmitters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_HackerLandRadioTransmitters.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}