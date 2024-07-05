import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultPairs {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs1(int k, List<Integer> arr) {
        // Write your code here

        if(arr.size() < 1)
            return 0;

        int count = 0;
        arr.sort(Comparator.reverseOrder());
        for(int i = 0; i < arr.size()-1; i++) {
            for(int j = i+1; j < arr.size(); j++)
                if(arr.get(i) - arr.get(j) == k)
                    count++;
        }
        return count;
    }

    public static int pairs2(int k, List<Integer> arr) {
        // Write your code here

        if(arr.size() < 1)
            return 0;

        arr.sort(Comparator.reverseOrder());
        int count = 0;
        for(int i = 0; i < arr.size(); i++)
            if(arr.subList(i+1, arr.size()).contains(arr.get(i) - k))
                count++;

        return count;
    }

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here

        if(arr.size() < 1)
            return 0;

        arr.sort(Comparator.naturalOrder());
        int[] countArray = new int[arr.get(arr.size()+k)];
        for(int i = 0; i < countArray.length; i++)
            countArray[i] = 1;



        int count = 0;
        for(int i = 0; i < arr.size(); i++)
            if(arr.subList(i+1, arr.size()).contains(arr.get(i) - k))
                count++;

        return count;
    }
}

public class SolutionPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultPairs.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}