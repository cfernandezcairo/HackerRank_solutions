import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_MaximunSubarray {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    static List<Integer>  maxSubarray(List<Integer>  arr) {
        int max_so_far = Integer.MIN_VALUE, max_end_here = 0, maxSum = 0;
        List<Integer>  ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0)
                maxSum += arr.get(i);
            max_end_here += arr.get(i);
            max_end_here = Math.max(max_end_here, arr.get(i));
            max_so_far = Math.max(max_so_far, max_end_here);
        }
        ans.add(max_so_far);
        max_so_far = max_so_far < 0 ? max_so_far : maxSum;
        ans.add(max_so_far);
        return ans;
    }

    public static List<Integer> maxSubarray1(List<Integer> arr) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        long positives = arr.stream().filter(a -> a>=0).count();
        long negatives = arr.size() - positives;
        Integer maxSubsequence = 0;

        if(positives == arr.size()) {
            maxSubsequence = arr.stream().mapToInt(x->x).sum();
            result.add(maxSubsequence);
            result.add(maxSubsequence);
        } else if (negatives == arr.size()) {
            arr.sort(Comparator.reverseOrder());
            result.add(arr.get(0));
            result.add(arr.get(0));
        } else {

            List<Integer> arrProcess = new ArrayList<>();
            Integer acc = 0;
            for(Integer i : arr) {
                if(i < 0) {
                    if (acc > 0) {
                        arrProcess.add(acc);
                        acc = 0;
                    }
                    arrProcess.add(i);
                } else {
                    acc+=i;
                    maxSubsequence+=i;
                }
            }
            if (acc > 0) {
                arrProcess.add(acc);
            }


            Integer prevMaxArray = 0;
            Integer maxArray = 0;
            boolean firstNegative = false;
            for(int i = 0; i < arrProcess.size(); i++) {
                Integer c = arrProcess.get(i);
                if(c < 0) {
                    if(!firstNegative) {
                        firstNegative = true;
                        maxArray+=c;
                    } else {
                        firstNegative = false;
                        i-=2;

                        prevMaxArray = Math.max(maxArray, prevMaxArray);
                        maxArray = 0;
                    }
                } else
                    maxArray+=c;
            }

            prevMaxArray = Math.max(maxArray, prevMaxArray);
            result.add(prevMaxArray);
            result.add(maxSubsequence);
        }

        return result;
    }

}

public class Solution_MaximunSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result_MaximunSubarray.maxSubarray(arr);

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