```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of days
        int N = sc.nextInt();
        int[] sales = new int[N];

        // Read sales data
        for (int i = 0; i < N; i++) {
            sales[i] = sc.nextInt();
        }

        // Input number of queries
        int Q = sc.nextInt();

        // Process each query
        for (int q = 0; q < Q; q++) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            int totalSales = 0;

            // Sum the sales between L and R (inclusive)
            for (int i = L; i <= R; i++) {
                totalSales += sales[i];
            }

            // Print the total
            System.out.println(totalSales);
        }

        sc.close();
    }
}
````