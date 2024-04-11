import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultBetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here

        Set<Integer> commonDivisorsB = new HashSet<>();
        b.sort(Comparator.naturalOrder());
        for(int i = 0; i < b.size() - 1; i++) {

        }

        return 0;
    }

    public static int getTotalX_HackerRank(List<Integer> a, List<Integer> b) {
        // Write your code here

        /* Find LCM of arrayA. Find GCD of arrayB */
        int A_LCM = lcm(a);
        int B_GCD = gcd(b);

        /* Calculate # of integers "between" arrayA and arrayB */
        int count = (B_GCD % A_LCM == 0) ? numDivisors(B_GCD / A_LCM) : 0;
        return count;
    }

    private static int lcm(List<Integer> array) {
        return array.stream().reduce(array.get(0), (a, b) -> lcm(a, b));
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(List<Integer> array) {
        return array.stream().reduce(array.get(0), (a, b) -> gcd(a, b));
    }
    private static int gcd(int a, int b) { // Euclid's GCD Algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Get num divisors of n
    private static int numDivisors(int n) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) { // if "i" is a divisor
                count += 2;   // account for both divisors
            }
        }
        /* If sqrt is a divisor, we should only count it once */
        if (sqrt * sqrt == n) {
            count--;
        }
        return count;
    }

}

public class SolutionBetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = ResultBetweenTwoSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}