import java.io.*;
import java.lang.*;
import java.util.stream.IntStream;

public class SolutionSumvsXor {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
        // Write your code here

        long count = 0;
        for(long x = 0; x <= n; x++) {
            long sum = x + n;
            long xor = x ^ n;

            //System.out.println(sum + "---" + xor);

            if(sum == xor)
                count++;
        }

        return count;
    }

    private static long getNumberOfOnes(long n) {
        long result = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                result += 1;
            }
            n >>>= 1;
        }
        return result;
    }
    public static long sumXor1(long n) {
        // Write your code here
        return (long) Math.pow(2, getNumberOfOnes(n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = sumXor(n);
        long result1 = sumXor1(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.write(String.valueOf(result1));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}