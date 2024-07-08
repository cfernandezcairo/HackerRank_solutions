import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result_JesseCookies {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies1(int k, List<Integer> A) {
        // Write your code here
        A.sort(Comparator.naturalOrder());
        if(!A.isEmpty() && (A.get(0) > k || A.size() == 1))
            return  -1;

        int operations  = 0;
        while(A.get(0) < k) {
            Integer sweet1 = A.remove(0);
            Integer sweet2 = A.remove(0);

            operations++;

            A.add(sweet1+(2*sweet2));
            A.sort(Comparator.naturalOrder());
        }

        return  operations;

    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> ACopy = A.stream().collect(Collectors.toCollection(PriorityQueue::new));

        int count = 0;
        while (ACopy.size() > 1 && ACopy.peek() <= k) {
            int first = ACopy.poll();
            int second = ACopy.poll();
            ACopy.add(first + 2 * second);
            count++;
        }

        return ACopy.peek() < k ? -1 : count;

    }

}

public class Solution_JesseCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_JesseCookies.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}