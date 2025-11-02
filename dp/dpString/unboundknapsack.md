```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();   // number of items
        int W = sc.nextInt();   // max weight
        
        int[] weight = new int[n];
        int[] value = new int[n];
        
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();
        
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();
        
        int[][] dp = new int[n + 1][W + 1];
        
        // Build table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        value[i - 1] + dp[i - 1][w - weight[i - 1]], 
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // Result is in dp[n][W]
        System.out.printf("%.2f", (double) dp[n][W]);
        sc.close();
    }
}
```