# lcs
 - Problem:
    Find the length of the Longest Common Subsequence (LCS) between two strings.
    A subsequence is a sequence that appears in the same relative order but not necessarily contiguous.
 - Example 1
    Input:
    s1 = "acd"
    s2 = "ced"

    Output:
    The Length of Longest Common Subsequence is 2

 - Example 2
    Input:
    s1 = "abcde"
    s2 = "ace"

    Output:
    The Length of Longest Common Subsequence is 3

```java
import java.util.*;
class TUF {
    static String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Reconstruct the LCS string (without StringBuilder)
        String lcs = "";
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // add character to front (since we go backwards)
                lcs = s1.charAt(i - 1) + lcs;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        String ans = lcs(s1, s2);
        System.out.println("The Length of Longest Common Subsequence is " + ans.length());
        System.out.println("The Longest Common Subsequence is: " + ans);
    }
}
````

leetcode : 
   
