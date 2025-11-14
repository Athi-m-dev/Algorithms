```java
 
import java.util.*;
class main {
    static int getPalindrome(String s1  , String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row , -1);
        }
        
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    static int longestPalindromeSubsequence(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        return getPalindrome(s1 , s2);
    }
    
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        String s = obj.next();

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }
}
```