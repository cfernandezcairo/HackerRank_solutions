import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LeftRotationSolution {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft_Bhavesh(int d, List<Integer> arr) {
        // Write your code here

        int size = arr.size();
        List<Integer>result = new ArrayList<>();

        for(int i = d; i < size; i++) {
            result.add(arr.get(i));
        }

        for(int i = 0; i < d; i++) {
            result.add(arr.get(i));
        }

        return result;

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        Integer[] rotated = new Integer[size];

        for(int i = 0; i < size; i++) {
            int newIndex = d*(size - i)%size + 1;
            newIndex = (newIndex == size) ? 0 : newIndex;
            rotated[newIndex] = arr.get(i);
        }

        return Arrays.asList(rotated);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = rotateLeft_Bhavesh(d, arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
