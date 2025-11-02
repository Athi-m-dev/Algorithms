```java
import java.util.*;
public class Main {

    static int minPath(int i, int j, int[][] grid) {
        // Base case: reached the starting cell
        if (i == 0 && j == 0)
            return grid[0][0];
        
        // If out of bounds, return large number
        if (i < 0 || j < 0)
            return (int) 1e9;

        // Recursive calls: from top and left
        int up = grid[i][j] + minPath(i - 1, j, grid);
        int left = grid[i][j] + minPath(i, j - 1, grid);

        return Math.min(up, left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minPath(n - 1, m - 1, grid));
    }
}

```java 