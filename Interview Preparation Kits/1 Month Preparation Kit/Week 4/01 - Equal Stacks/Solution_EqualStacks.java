import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here

        Map<Integer, Stack<Integer>> process = new HashMap<>();

        Stack<Integer> stackH1 = new Stack<>();
        Integer sizeH1 = 0;
        for(int i = h1.size(); i > 0; i--) {
            Integer c = h1.get(i-1);
            sizeH1 += c;
            stackH1.push(c);
        }

        Stack<Integer> stackH2 = new Stack<>();
        int sizeH2  = 0;
        for(int i = h2.size(); i > 0; i--) {
            Integer c = h2.get(i-1);
            sizeH2 += c;
            stackH2.push(c);
        }

        Stack<Integer> stackH3 = new Stack<>();
        int sizeH3  = 0;
        for(int i = h3.size(); i > 0; i--) {
            Integer c = h3.get(i-1);
            sizeH3 += c;
            stackH3.push(c);
        }

        while (true) {
            if (sizeH1 == sizeH2 && sizeH2 == sizeH3) {
                return sizeH1;
            } else if(sizeH1 > sizeH2) {
                sizeH1-=stackH1.pop();
            } else if (sizeH3 > sizeH2) {
                sizeH3-=stackH3.pop();
            } else {
                sizeH2-=stackH2.pop();
            }
        }

    }

}

public class Solution_EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_EqualStacks.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}