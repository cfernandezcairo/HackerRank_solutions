// github.com/RodneyShag

import java.util.Scanner;
import java.util.HashMap;

public class MinimunDistances_Solution {

// Main trick: Use a HashMap<Integer, Integer> that maps from "value" to "index"
//             to keep track of the largest index for each value that we've
//             seen so far as we loop through array

//  Time Complexity: O(n)
// Space Complexity: O(n)

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] array) {
        HashMap<Integer, Integer> map = new HashMap();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int prevIndex = map.get(array[i]);
                int currDistance = i - prevIndex;
                minDistance = Math.min(minDistance, currDistance);
            }
            map.put(array[i], i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        /* Save input */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] cloud = new int[n];
        for (int i = 0; i < n; i++) {
            cloud[i] = scan.nextInt();
        }
        scan.close();

    }
}

// Discuss on HackerRank: https://www.hackerrank.com/challenges/minimum-distances/forum/comments/360084
