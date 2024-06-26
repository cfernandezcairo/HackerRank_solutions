// github.com/RodneyShag

import java.util.BitSet;
import java.util.Scanner;

public class Gemstones_Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
    }


    static int gemstones(String[] array) {
        final int NUM_ELEMENTS = 26;
        BitSet bitset = new BitSet(NUM_ELEMENTS);
        bitset.set(0, NUM_ELEMENTS);

        /* Create a BitSet for each rock. "AND" it with our original BitSet */
        for (String rock : array) {
            BitSet currBitSet = new BitSet(NUM_ELEMENTS);
            for (int i = 0; i < rock.length(); i++) {
                currBitSet.set(rock.charAt(i) - 'a');
            }
            bitset.and(currBitSet);
        }

        return bitset.cardinality();
    }

}

// Discuss on HackerRank: https://www.hackerrank.com/challenges/gem-stones/forum/comments/284428
