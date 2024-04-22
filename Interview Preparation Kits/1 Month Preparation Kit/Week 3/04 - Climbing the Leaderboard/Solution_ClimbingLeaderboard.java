import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_ClimbingLeaderboard {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard1(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        List<Integer> result = new ArrayList<>();

        int n = ranked.size();
        int lastScore = -1;
        int[] scores = new int[n];
        int index = 0;
        
        while (n-- > 0) {
            int currScore = ranked.get(ranked.size() - (n+1));
            if (currScore != lastScore) {
                scores[index] = currScore;
                index++;
            }
            lastScore = currScore;
        }

        /* Print ranks */
        int i = index - 1;
        for (int playerScore : player) {
            while (i >= 0) {
                if (playerScore < scores[i]) {
                    result.add(i+2);
                    break;
                }
                i--;
            }
            if (i < 0) { // if true, each remaining playerScore is highest score
                result.add(1);
            }
        }
        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        HashMap<Integer, Integer> ranking = new HashMap<>();
        int rank = 0;
        List<Integer> result = new ArrayList<>();

        for(Integer r : ranked) {
            if(!ranking.containsKey(r))
                ranking.put(r, ++rank);
        }

        int i = 0;
        int currentPlayerGame;
        List<Integer> reversedKeySet = new ArrayList<>(ranking.keySet());
        Collections.sort(reversedKeySet, Comparator.naturalOrder());
        for(Integer r : reversedKeySet) {
            currentPlayerGame = player.get(i);
            if(currentPlayerGame < r) {
                result.add(ranking.get(r) + 1);
                i++;
            }
            if(currentPlayerGame == r) {
                result.add(ranking.get(r));
                i++;
            }
        }

        for(int j = i; j < player.size(); j++)
            result.add(1);

        return result;
    }
}

public class Solution_ClimbingLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_ClimbingLeaderboard.climbingLeaderboard1(ranked, player);

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