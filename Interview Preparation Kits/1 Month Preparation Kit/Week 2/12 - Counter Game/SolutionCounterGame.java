import java.io.*;
import java.math.BigInteger;
import java.lang.*;
import java.util.stream.IntStream;

public class SolutionCounterGame {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    // Function to calculate the
    // log base 2 of an integer
    /*
    * log_a b = log_e b / log_e a
    * log_2 N = log_e N / log_e 2
    * log_2 N = log N / log 2
    */
    public static Double log2(int N) {
        // calculate log2 N indirectly
        // using log() method
        double result = (Math.log(N) / Math.log(2));
        return result;
    }

    static int sumFromString(String s){
        int sum = IntStream.range(0, s.length()).map(i -> Character.getNumericValue(s.charAt(i))).sum();
        return sum;
    }
    public static String counterGame(long n) {
        // Write your code here

        String binary = Long.toBinaryString(n);

        String left = binary.substring(0, binary.lastIndexOf('1'));
        String right = binary.substring(binary.lastIndexOf('1'));

        return (sumFromString(left) + right.length()) % 2 == 0 ? "Louise" : "Richard";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}