import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_Waiter {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {     // account for even numbers now, so that we can do i+=2 in loop below
            return true;
        } else if (n % 2 == 0) { // account for even numbers now, so that we can do i+=2 in loop below
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) { // skips even numbers for faster results
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int nextPrime(int from) {
        while (true)
            return isPrime(from) ? from : nextPrime(from+1);
    }

    private static void process(Stack<Integer> from, Stack<Integer> a, Stack<Integer> b, int prime, List<Integer> result) {
        while (!from.isEmpty()) {
            int cNumber = from.pop();
            if (cNumber % prime == 0) {
                b.push(cNumber);
            } else {
                a.push(cNumber);
            }
        }
        while (!b.isEmpty())
            result.add(b.pop());
    }
    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        Stack<Integer> numberStack = new Stack<>();
        number.forEach(numberStack::push);

        Stack<Integer> aStack = new Stack<>();
        Stack<Integer> bStack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        int prime = 2;
        int it = 0;
        do {

            it++;
            if(it%2 !=0 )
                process(numberStack, aStack, bStack, prime, result);
            else
                process(aStack, numberStack, bStack, prime, result);

            q--;
            if(q!=0) {
                prime = nextPrime(prime+1);
            } else {
                while (!aStack.isEmpty())
                    result.add(aStack.pop());
                while (!numberStack.isEmpty())
                    result.add(numberStack.pop());
            }
        } while (q > 0);

        return result;
    }

}

public class Solution_Waiter {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_Waiter.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}