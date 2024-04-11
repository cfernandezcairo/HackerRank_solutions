import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SolutionRecursiveDigitSum {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    static BigInteger sumFromString(String s){
        BigInteger sum = BigInteger.valueOf(IntStream.range(0, s.length()).map(i -> Character.getNumericValue(s.charAt(i))).sum());
        return sum;
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        BigInteger superDigitk = sumFromString(n).multiply(BigInteger.valueOf(k));

        while (superDigitk.toString().length() > 1)
            superDigitk = sumFromString(String.valueOf(superDigitk));

        return superDigitk.intValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}