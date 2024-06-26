// github.com/RodneyShag

import java.util.Scanner;
import java.math.BigInteger;

public class ExtraLongFactorials_Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(factorial(n));
    }
    
    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        while (n > 1) {
            result = result.multiply(BigInteger.valueOf(n));
            n--;
        }
        return result;
    }
}
