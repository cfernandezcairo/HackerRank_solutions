import java.io.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class ResultFizzBuzz {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here

        String currentLine = "";
        for(int i = 1; i <= n; i++) {
            currentLine = "";

            if(i%3 == 0)
                currentLine += "Fizz";
            if(i%5 == 0)
                currentLine += "Buzz";

            if(currentLine.isEmpty())
                currentLine=String.valueOf(i);

            System.out.println(currentLine);
        }

    }

}

public class SolutionFizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ResultFizzBuzz.fizzBuzz(n);

        bufferedReader.close();
    }
}