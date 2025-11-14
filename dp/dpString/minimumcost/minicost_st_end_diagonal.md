```java
import java.util.*;
public class Main {
    static int minCost(int i, int j, int[][] grid) {
        // Base case: top-left cell
        if (i == 0 && j == 0)
            return grid[0][0];
        
        // Out of bounds
        if (i < 0 || j < 0)
            return (int) 1e9;  // large number to represent infinity

        // 3 possible moves
        int up = grid[i][j] + minCost(i - 1, j, grid);
        int left = grid[i][j] + minCost(i, j - 1, grid);
        int diagonal = grid[i][j] + minCost(i - 1, j - 1, grid);

        return Math.min(up, Math.min(left, diagonal));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minCost(R - 1, C - 1, grid));
    }
}
```java