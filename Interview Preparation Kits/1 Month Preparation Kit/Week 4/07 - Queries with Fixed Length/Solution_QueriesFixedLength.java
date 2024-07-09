import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result_QueriesFixedLength {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    private static void addElementsInFirstWindow(Queue<Integer> window, int querySubLength, int[] array) {
        for (int index = 0 ; index < querySubLength ; index++) {
            window.add(array[index]);
        }
    }

    private static int minimumIntInRange(int[] array, int querySubLength) {
        Queue<Integer> window = new LinkedList<>();
        addElementsInFirstWindow(window, querySubLength, array);

        int maximum = window.stream().max(Integer::compareTo).get();
        int minimum = maximum;

        //iterate for a rest of array, starting 2nd window index
        for (int index = querySubLength; index < array.length; index++) {

            int removed = window.poll();
            int inserted = array[index];
            window.add(inserted);

            if (inserted >= maximum) {
                maximum = inserted;
            } else if (removed == maximum) {
                maximum = window.stream().max(Integer::compareTo).get();
            }

            minimum = Math.min(minimum, maximum);
        }

        return minimum;
    }

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        int[] array = arr.stream().mapToInt(Integer::intValue).toArray();

        for (Integer query : queries) {
            if(query == 1) {
                result.add(arr.stream().min(Integer::compareTo).get());
            } else {
                result.add(minimumIntInRange(array, query));
            }
        }

        return result;
    }
    public static List<Integer> solve2(List<Integer> arr, List<Integer> queries) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        TreeSet<Integer> cMin = new TreeSet<>();
        for(Integer q : queries) {
            cMin.clear();
            for(int i = 0; i < arr.size()-(q-1); i++) {
                if(q == 1) {
                    cMin.add(arr.get(i));
                } else {
                    List<Integer> cM = arr.subList(i, i+q);
                    cMin.add(cM.stream().max(Comparator.naturalOrder()).get());
                }
            }
            result.add(cMin.first());
        }
        return result;
    }

    public static List<Integer> solve1(List<Integer> arr, List<Integer> queries) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        for(Integer q : queries) {
            Integer cResult = Integer.MAX_VALUE;
            for(int i = 0; i < arr.size()-(q-1); i++) {
                if(q == 1) {
                    cResult = Math.min(arr.get(i), cResult);
                } else {
                    List<Integer> cM = arr.subList(i, i+q);
                    cResult = Math.min(cM.stream().max(Comparator.naturalOrder()).get(), cResult);
                }
            }
            result.add(cResult);
        }
        return result;
    }
}

public class Solution_QueriesFixedLength {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_QueriesFixedLength.solve(arr, queries);

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