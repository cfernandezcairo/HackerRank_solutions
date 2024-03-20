// github.com/RodneyShag

import java.util.Scanner;

public class Substring_Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int start  = scan.nextInt();
        int end    = scan.nextInt();
        scan.close();
        
        System.out.println(str.substring(start, end));
    }
}
