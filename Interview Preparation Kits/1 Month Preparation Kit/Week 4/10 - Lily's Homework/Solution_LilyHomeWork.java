import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class Result_LilyHomeWork {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        // Write your code here
        int arraySize = arr.size();

        int sortedSwaps = 0;
        int[] homeworkArray = new int[arraySize];
        Map<Integer,Integer> originalHW = new HashMap<>();

        int sortedReverseSwaps = 0;
        int[] homeworkArray2nd = new int[arraySize];
        Map<Integer,Integer> originalHW2nd = new HashMap<>();

        //Initialize our arrays and maps
        Integer[] homeworkArraySorted = new Integer[arraySize];
        for(int i = 0; i < arraySize; i++)         {
            homeworkArraySorted[i] = arr.get(i);

            homeworkArray[i] = homeworkArraySorted[i];
            homeworkArray2nd[i] = homeworkArraySorted[i];

            originalHW.put(homeworkArray[i],i);
            originalHW2nd.put(homeworkArray2nd[i],i);
        }

        Arrays.sort(homeworkArraySorted);//Sort the input ascending
        for(int i = 0; i < arraySize; i++) {
            if(homeworkArray[i] != homeworkArraySorted[i]) {

                //swap the element from homework to the right position
                int tmp = homeworkArray[i];
                homeworkArray[i] = homeworkArray[originalHW.get(homeworkArraySorted[i])];
                homeworkArray[originalHW.get(homeworkArraySorted[i])] = tmp;

                //Update index after swap
                originalHW.put(tmp,originalHW.get(homeworkArraySorted[i]));
                sortedSwaps++;
            }
        }

        Arrays.sort(homeworkArraySorted, Collections.reverseOrder());//Sort the input descending
        for(int i = 0; i < arraySize; i++) {
            if(homeworkArray2nd[i] != homeworkArraySorted[i]) {

                //swap the element from homework to the right position
                int tmp = homeworkArray2nd[i];
                homeworkArray2nd[i] = homeworkArray2nd[originalHW.get(homeworkArraySorted[i])];
                homeworkArray2nd[originalHW2nd.get(homeworkArraySorted[i])] = tmp;

                //Update index after swap
                originalHW2nd.put(tmp, originalHW2nd.get(homeworkArraySorted[i]));
                sortedReverseSwaps++;
            }
        }

        return Math.min(sortedSwaps,sortedReverseSwaps);//Choose the smallest of the two possible smallest
    }

}

public class Solution_LilyHomeWork {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_LilyHomeWork.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}