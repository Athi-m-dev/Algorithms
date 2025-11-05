```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N = array size, n = sequence length
        int N = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = Integer.MAX_VALUE;

        // Loop over all sequences of length n
        for (int i = 0; i <= N - n; i++) {
            int currentMax = arr[i];

            // Find max in the current sequence
            for (int j = i; j < i + n; j++) {
                if (arr[j] > currentMax) {
                    currentMax = arr[j];
                }
            }

            // Track the minimum of maximums
            if (currentMax < result) {
                result = currentMax;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
````