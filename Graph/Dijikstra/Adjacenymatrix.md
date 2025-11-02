```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        int V = obj.nextInt(); // number of vertices

        // Read adjacency matrix
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = obj.nextInt();
            }
        }

        int src = obj.nextInt(); // source vertex

        // Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // Min-heap (priority queue)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            // Skip if outdated distance
            if (dis > dist[node]) continue;

            // Go through all neighbors in matrix form
            for (int v = 0; v < V; v++) {
                int weight = graph[node][v];
                if (weight != 0 && dist[node] + weight < dist[v]) {
                    dist[v] = dist[node] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        // Output format
        System.out.println("Vertex \tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t\t " + dist[i]);
        }
    }
}
```