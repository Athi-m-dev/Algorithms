```java
 import java.util.*;
public class Main {
    static int minEditCost(String s1, String s2, int insertCost, int deleteCost, int replaceCost) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        // Base cases
        for (int i = 0; i <= n; i++) dp[i][0] = i * deleteCost; // deleting all chars
        for (int j = 0; j <= m; j++) dp[0][j] = j * insertCost; // inserting all chars

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no cost if same char
                } else {
                    int insert = insertCost + dp[i][j - 1];
                    int delete = deleteCost + dp[i - 1][j];
                    int replace = replaceCost + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m1 = sc.next();
        String m2 = sc.next();

        int insertCost = sc.nextInt();
        int deleteCost = sc.nextInt();
        int replaceCost = sc.nextInt();

        int result = minEditCost(m1, m2, insertCost, deleteCost, replaceCost);
        System.out.println(result);

        sc.close();
    }
}
```java