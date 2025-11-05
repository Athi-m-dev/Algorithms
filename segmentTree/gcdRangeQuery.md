```java
Check GCD in Range Query:
import java.util.*;

public class Main {
    // Function to compute GCD (same logic as in C++)
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Number of queries
        int Q = sc.nextInt();

        // Process each query
        while (Q-- > 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int K = sc.nextInt();

            int gcdVal = 0;
            boolean found = false;

            for (int i = L; i <= R; i++) {
                if (arr[i] % K == 0) {
                    if (!found) {
                        gcdVal = arr[i];
                        found = true;
                    } else {
                        gcdVal = gcd(gcdVal, arr[i]);
                    }
                }
            }

            System.out.println(found ? gcdVal : 0);
        }

        sc.close();
    }
}


````