// github.com/RodneyShag

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class JumpingOnTheClouds_Solution {

    private static int jumping_cfernandezcairo(List<Integer> c) {

        Map<Integer, Integer> splitted = new HashMap();
        int splittedCount = 0;
        int lastZero = 0;

        for(int i = 0; i < c.size(); i++) {
            if(c.get(i) == 1) {
                splitted.put(++splittedCount, i - lastZero);
                lastZero = i + 1;
            }
        }
        splitted.put(++splittedCount, c.size() - lastZero);

        AtomicInteger result = new AtomicInteger();
        splitted.forEach((k,v) -> {
            result.addAndGet((v % 2 == 0) ? v / 2 + v % 2 : v / 2);
        });


        return result.get() + splitted.size() - 1;
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
        
        /* Jump on clouds */
        int jumps = 0;
        int i     = 0;
        while (i < n - 1) {
            if (i + 2 < n && cloud[i + 2] == 0) {
                i += 2;
            } else {
                i++;
            }
            jumps++;
        }
        System.out.println(jumps);

        System.out.println(jumping_cfernandezcairo(cloud));
    }
}
