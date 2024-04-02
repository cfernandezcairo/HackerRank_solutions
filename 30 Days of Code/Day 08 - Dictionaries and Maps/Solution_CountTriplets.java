import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long result = 0;
        if(arr.size()<3) return result;

        arr.sort(Comparator.naturalOrder());
        for(int i = 0; i < arr.size() - 2; i++) {
            int j = i + 1;
            for (; j < arr.size() - 1; j++) {
                if(arr.get(i) * r == arr.get(j)) {
                    int k = j + 1;
                    for(; k < arr.size(); k++) {
                        if(arr.get(j) * r == arr.get(k)) {
                            //System.out.println("i: " + i + ", j: " + j + ", k: " + k);
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

    /*
    *
    *  a/r, a, a*r  triplets based on frecuency of a in left an right of middle term
    *
    */
    static long countTriplets_javaaids(List<Long> arr, long r) {

        /*
        * Maps of terms and it occurrence frecuency
        */
        Map<Long, Long> leftTermsFrecuency = new HashMap<>();
        Map<Long, Long> rightTermsFrecuency = new HashMap<>();

        /*Init occurence frecuency af all terms. will assume that left terms array is empty*/
        for (long item : arr) {
            rightTermsFrecuency.put(item, rightTermsFrecuency.getOrDefault(item, 0L) + 1);
        }

        long countTriplets = 0;
        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            long leftMiddleTermTripletFrecuency = 0, rightMiddleTermTripletFrecuency = 0;

            //Decrease frecuency of current middle term on right array
            rightTermsFrecuency.put(midTerm, rightTermsFrecuency.getOrDefault(midTerm, 0L) - 1);


            /*get frecuency of left and right triplet terms*/
            if (leftTermsFrecuency.containsKey(midTerm / r) && midTerm % r == 0)
                leftMiddleTermTripletFrecuency = leftTermsFrecuency.get(midTerm / r);
            if (rightTermsFrecuency.containsKey(midTerm * r))
                rightMiddleTermTripletFrecuency = rightTermsFrecuency.get(midTerm * r);

            // triplets count it is a combination of frecuencies
            countTriplets += leftMiddleTermTripletFrecuency * rightMiddleTermTripletFrecuency;

            ////Increase frecuency of current middle term on left array
            leftTermsFrecuency.put(midTerm, leftTermsFrecuency.getOrDefault(midTerm, 0L) + 1);

        }
        return countTriplets;
    }

}

public class Solution_CountTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = Result_CountTriplets.countTriplets(arr, r);
        long ans1 = Result_CountTriplets.countTriplets1(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.write(String.valueOf(ans1));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}