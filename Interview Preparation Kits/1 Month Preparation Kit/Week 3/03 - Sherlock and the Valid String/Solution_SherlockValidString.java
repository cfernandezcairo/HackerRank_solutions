import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_SherlockValidString {
    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<Character, Integer> charFrecuency = new HashMap<>();
        for(char c :  s.toCharArray()) {
            if(charFrecuency.containsKey(c)) {
                charFrecuency.put(c, charFrecuency.get(c) + 1);
            } else
                charFrecuency.put(c, 1);
        }

        Map<Integer, Integer> occurrenceFrecuency = new HashMap<>();
        for(Integer o : charFrecuency.values()) {
            if(occurrenceFrecuency.containsKey(o)) {
                occurrenceFrecuency.put(o, occurrenceFrecuency.get(o) + 1);
            } else
                occurrenceFrecuency.put(o, 1);
        }

        if(occurrenceFrecuency.keySet().size() == 1)
            return "YES";
        else if(occurrenceFrecuency.keySet().size() == 2 ) {
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            for(int n : occurrenceFrecuency.keySet()) {
                if(i == 0){
                    f1 = n;
                    f1Count = occurrenceFrecuency.get(n);
                } else{
                    f2 = n;
                    f2Count = occurrenceFrecuency.get(n);
                }
                i++;
            }

            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return "YES";
            else
                return "NO";
        }

        return "NO";
    }
}

public class Solution_SherlockValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result_SherlockValidString.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}