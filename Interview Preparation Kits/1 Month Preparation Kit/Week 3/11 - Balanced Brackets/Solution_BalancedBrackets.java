import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result_BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    /* Create HashMap to match opening brackets with closing brackets */

    private static HashMap<Character, Character> map = new HashMap();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> balancedCheck = new Stack<>();

        for(char c : s.toCharArray())
            if (map.containsKey(c)) balancedCheck.push(c);
            else if (balancedCheck.isEmpty() || !map.get(balancedCheck.pop()).equals(c))
                return "NO";

        return balancedCheck.isEmpty() ? "YES":"NO";
    }

}

public class Solution_BalancedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result_BalancedBrackets.isBalanced(s);

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