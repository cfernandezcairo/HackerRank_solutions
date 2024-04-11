// github.com/RodneyShag

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SolveMeFirst_Result {

    public static int solveMeFirst(int a, int b) {
        return a+b;
    }

}

public class SolveMeFirst_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.valueOf(bufferedReader.readLine());
        int b = Integer.valueOf(bufferedReader.readLine());

        int result = SolveMeFirst_Result.solveMeFirst(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
