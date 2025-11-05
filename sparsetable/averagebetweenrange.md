```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of days
        int N = sc.nextInt();
        int[] sales = new int[N];

        // Sales data
        for (int i = 0; i < N; i++) {
            sales[i] = sc.nextInt();
        }

        // Number of queries
        int Q = sc.nextInt();

        // Process each query
        for (int q = 0; q < Q; q++) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int T = sc.nextInt(); // threshold

            int sum = 0;

            // Compute total sales in range [L, R]
            for (int i = L; i <= R; i++) {
                sum += sales[i];
            }

            // Calculate average
            double avg = (double) sum / (R - L + 1);

            // Compare average with threshold
            if (avg >= T) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
````