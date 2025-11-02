```java
 import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // number of intersections
        int m = sc.nextInt();  // number of roads
        
        // adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        // read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // because roads are two-way
        }
        
        int src = sc.nextInt();   // source warehouse
        int dest = sc.nextInt();  // destination warehouse
        
        // Dijkstra's algorithm
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});
        dist[src] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int wt = edge[1];
                
                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.add(new int[]{dist[next], next});
                    parent[next] = node;
                }
            }
        }
        
        // if no path
        if (dist[dest] == (int)1e9) {
            System.out.println("No path found");
            return;
        }
        
        // reconstruct the path
        List<Integer> path = new ArrayList<>();
        int node = dest;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);
        
        // print results
        System.out.print("Shortest path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
        System.out.println("Shortest distance: " + dist[dest]);
    }
}
```