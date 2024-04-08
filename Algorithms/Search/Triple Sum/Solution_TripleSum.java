import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_TripleSum {

    /*
     * Complete the 'triplets' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     *  3. INTEGER_ARRAY c
     */

    private static int[] removeDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int item : a) {
            set.add(item);
        }
        int len = set.size();

        int result[] = new int[len];
        int i = 0;
        for (int item : set) {
            result[i++] = item;
        }
        return result;
    }

    static int getValidIndex(int[] distincts, int key) {
        int low = 0;
        int high = distincts.length - 1;
        int count = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (distincts[mid] <= key) {
                count = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return count;

    }
    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {

        long tripletsCount = 0;
        int[] aArray = a.stream().mapToInt(Integer::intValue).toArray();
        int[] bArray = b.stream().mapToInt(Integer::intValue).toArray();
        int[] cArray = c.stream().mapToInt(Integer::intValue).toArray();

        Set<Integer> aSet = Arrays.stream(aArray).boxed().collect(Collectors.toCollection(HashSet::new));
        int[] aDistinctsArray_1 = aSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(aDistinctsArray_1);
        /*------------------------------------------------------------------*/
        int[] aDistinctsArray_2 = removeDuplicates(aArray);
        Arrays.sort(aDistinctsArray_2);




        Set<Integer> bSet = Arrays.stream(bArray).boxed().collect(Collectors.toCollection(HashSet::new));
        int[] bDistinctsArray_1 = bSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(bDistinctsArray_1);
        /*------------------------------------------------------------------*/
        int[] bDistinctsArray_2 = removeDuplicates(bArray);
        Arrays.sort(bDistinctsArray_2);



        Set<Integer> cSet = Arrays.stream(cArray).boxed().collect(Collectors.toCollection(HashSet::new));
        int[] cDistinctsArray_1 = cSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(cDistinctsArray_1);
        /*------------------------------------------------------------------*/
        int[] cDistinctsArray_2 = removeDuplicates(cArray);
        Arrays.sort(cDistinctsArray_2);

        for(Integer q : bDistinctsArray_1) {

            long aValidCount_1 = getValidIndex(aDistinctsArray_1, q) + 1;
            long cValidCount_1 = getValidIndex(cDistinctsArray_1, q) + 1;

            long aValidCount_2 = getValidIndex(aDistinctsArray_2, q) + 1;
            long cValidCount_2 = getValidIndex(cDistinctsArray_2, q) + 1;

            tripletsCount+=aValidCount_1*cValidCount_1;

        }

        return tripletsCount;
    }

}

public class Solution_TripleSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int lena = Integer.parseInt(firstMultipleInput[0]);

        int lenb = Integer.parseInt(firstMultipleInput[1]);

        int lenc = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> arra = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> arrb = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> arrc = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long ans = Result_TripleSum.triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}