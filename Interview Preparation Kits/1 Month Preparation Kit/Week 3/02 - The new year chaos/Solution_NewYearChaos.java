import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_NewYearChaos {
    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        Integer minBribe = 0;
        int currentBribes = 0;
        int tmp = 0;
        for(int i = 0; i < q.size(); i++) {
            if(q.get(i).intValue() != i+1) {
                currentBribes = q.get(i) - ( i + 1);
                if(Math.abs(currentBribes) > 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    //tmp = q.get(i);
                    //q.set(i, i+1);
                    //q.set(i+1, tmp);

                    minBribe++;
                }
            }
        }

        System.out.println(minBribe);

    }

    private static int insertInRight(int candidate, List<Integer> right) {

        int offset = -1;
        int rightLenght = right.size();
        boolean insertedCandidate = false;
        for(int i = 0; i < rightLenght; i++) {
            if(candidate < right.get(i)) {

                right.subList(0, i).add(candidate);
                return ++offset;

            } else {
                offset++;
            }
        }

        if(!insertedCandidate) {
            right.add(candidate);
            offset++;
        }

        return offset;
    }
    public static void minimumBribes_1(List<Integer> q) {
        // Write your code here

        List<Integer> rightList = new ArrayList<>();
        rightList.add(q.get(q.size()-1));
        int currentRightOffsetPosition;
        int bribes = 0;
        for(int i = q.size() - 2; i >=0; i--) {
            currentRightOffsetPosition = insertInRight(q.get(i), rightList);

            if(currentRightOffsetPosition > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                if(currentRightOffsetPosition!=0)
                    bribes+=currentRightOffsetPosition;
            }
        }
        System.out.println(bribes);
    }
}

public class Solution_NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result_NewYearChaos.minimumBribes_1(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}