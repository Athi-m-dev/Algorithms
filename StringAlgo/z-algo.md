``` java 
/**
 *
 * Z algorithm to pattern matching
 *
 * Time complexity - O(n + m)
 * Space complexity - O(n + m)
 *
 * http://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
 * http://www.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
 */
import java.util.*;

public class Main {

    static int[] computeZArray(String str) {
        int n = str.length();
        int[] Z = new int[n];
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;  // to find the  value in my prefix one 
                if (Z[k] < R - i + 1) // is it exeding my right boundary
                    Z[i] = Z[k];
                else {   // if execind it have more than one char same
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    static void search(String text, String pattern) {
        String combined = pattern + "$" + text;
        int[] Z = computeZArray(combined);

        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index: " + (i - pattern.length() - 1));
            }
        }
    }

    
    public static void main(String[] args) {
        String text = "aabxaabxaaab";
        String pattern = "aab";
        search(text, pattern);
    }
}

```` java