// github.com/RodneyShag

import java.util.Scanner;

public class CaesarCipher_Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
    }


    static String caesarCipher(String str, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(encrypt(ch, k));
        }
        return sb.toString();
    }

    /* Encrypts a character using Caesar Cipher */
    private static char encrypt(char ch, int K) {
        if (!Character.isLetter(ch)) {
            return ch;
        }
        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch - base + K) % 26 + base);
    }

}

// Discuss on HackerRank: https://www.hackerrank.com/challenges/caesar-cipher-1/forum/comments/269393
