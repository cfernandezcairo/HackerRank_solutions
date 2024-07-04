import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution_QueueUsingTwoStacks {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        IntStream.range(0, q).forEach(tItr -> {
            try {

                Object[] currentQ = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(String::toString)
                        .toArray();
                String command = (String) currentQ[0];

                switch (command) {
                    case "1" -> {
                        stack1.push(Integer.valueOf((String) currentQ[1]));
                    }
                    case "2" -> {
                        if (stack2.isEmpty()) { //Llevar a stack2 para sacar el primero
                            while (!stack1.isEmpty()) {
                                stack2.push(stack1.pop());
                            }
                        }

                        // sacando el primero
                        if(!stack2.isEmpty())
                            stack2.pop();
                    }
                    case "3" -> {
                        if (stack2.isEmpty()) { //Llevar a stack2 para sacar el primero
                            while (!stack1.isEmpty()) {
                                stack2.push(stack1.pop());
                            }
                        }

                        // imprimiendo el primero
                        if(!stack2.isEmpty())
                            bufferedWriter.write( stack2.peek() + "\n" );
                    }
                    default -> {}
                }


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}