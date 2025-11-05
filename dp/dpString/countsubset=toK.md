# Example
  - Input 1 :
    6
    1 2 3 4 5 6
    7
  - Output 1 :
    4
    18
  - Input 2 :
    5
    2 4 6 10 12
    16
  - Output 2 :
    3
    16

```java
import java.util.*;
class Main {
    static int getset(int[] nums , int n , int target , int[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
    
    static int findcombination(int[] nums , int n , int target) {
        int[][] dp = new int[n+1][target+1];
        for (int[] row : dp) {
            Arrays.fill(row , 0);
        }
        
        return getset(nums , n , target , dp);
        
    }
    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = obj.nextInt();
        }
        
        int target = obj.nextInt();
        System.out.println(findcombination(nums , n , target));
    }
}
```java