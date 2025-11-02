```java
 import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int v = obj.nextInt();
        int e = obj.nextInt();
        int INF = 999999;

        int[][] grid = new int[v][v];

        // Initialize matrix
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j)
                    grid[i][j] = 0;
                else
                    grid[i][j] = INF;
            }
        }

        // Read edges (undirected)
        for (int i = 0; i < e; i++) {
            int u = obj.nextInt();
            int nv = obj.nextInt();
            int w = obj.nextInt();
            grid[u][nv] = w;
            grid[nv][u] = w; // because undirected
        }

        // Print original matrix
        System.out.println("Original matrix");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (grid[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // Floyd–Warshall algorithm
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (grid[i][k] + grid[k][j] < grid[i][j])
                        grid[i][j] = grid[i][k] + grid[k][j];
                }
            }
        }

        // Print shortest path matrix
        System.out.println("\nShortest path matrix");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (grid[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
````