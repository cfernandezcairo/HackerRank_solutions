import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result_FlippingBits {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits_cfernandezcairo(long n) {
        // Write your code here
        long num = (1L<<32)-1;

        System.out.println(n^num);

        return n^num;

    }

    public static long flippingBits_linchenghao1999(long n) {
        // Write your code here
        return (long)Math.pow(2,32) + (~n);
    }

}

public class Solution_FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result_FlippingBits.flippingBits_cfernandezcairo(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}