import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution_TextEditor {

    private static StringBuffer s = new StringBuffer();
    private static Stack<Map<Integer, String>> operations = new Stack<Map<Integer, String>>();

    private static void append(String w, boolean saveOps) {
        Map<Integer, String> currentOp = new HashMap<>();
        currentOp.put(1, w);

        s.append(w);
        if(saveOps)
            operations.push(currentOp);
    }

    private static void delete(Integer k, boolean saveOps) {
        String w = s.substring(s.length()-k, s.length());
        Map<Integer, String> currentOp = new HashMap<>();
        currentOp.put(2, w);

        s.delete(s.length()-k, s.length());
        if(saveOps)
            operations.push(currentOp);
    }

    private static void print(BufferedWriter bufferedWriter, Integer k) throws IOException {
        bufferedWriter.write(s.charAt(k-1));
        bufferedWriter.newLine();
    }

    private static void undo() {
        Map<Integer, String> currentOp = operations.pop();

        switch ((Integer) currentOp.keySet().toArray()[0]) {
            case 1:
                delete(currentOp.get((Integer) currentOp.keySet().toArray()[0]).length(), false);
                break;
            case 2:
                append(currentOp.get((Integer) currentOp.keySet().toArray()[0]), false);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine());
        IntStream.range(0, q).forEach(tItr -> {
            try {
                String[] multipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                Integer command = Integer.valueOf(multipleInput[0]);

                switch (command) {
                    case 1:
                        append(multipleInput[1], true);
                        break;
                    case 2:
                        delete(Integer.valueOf(multipleInput[1]), true);
                        break;
                    case 3:
                        print(bufferedWriter, Integer.valueOf(multipleInput[1]));
                        break;
                    case 4:
                        undo();
                        break;
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}