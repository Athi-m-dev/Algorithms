```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of days
        int N = sc.nextInt();
        int[] AQI = new int[N];

        // AQI values
        for (int i = 0; i < N; i++) {
            AQI[i] = sc.nextInt();
        }

        // Number of queries
        int Q = sc.nextInt();

        // Process each query
        for (int q = 0; q < Q; q++) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            int minVal = Integer.MAX_VALUE;

            // Check all AQI values between L and R
            for (int i = L; i <= R; i++) {
                if (AQI[i] < minVal) {
                    minVal = AQI[i];
                }
            }

            System.out.println(minVal);
        }

        sc.close();
    }
}
````