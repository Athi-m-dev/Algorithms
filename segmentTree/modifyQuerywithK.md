```java
 // You are using Java
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of elements
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int Q = sc.nextInt(); // number of queries

        while (Q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();

            // Convert to 0-based indexing
            l--;
            r--;

            int[] freq = new int[101]; // frequency for user IDs (1–100)

            // Count frequency in the range [l, r]
            for (int i = l; i <= r; i++) {
                freq[arr[i]]++;
            }

            // Count users who appear at least k times
            int countUsers = 0;
            for (int user = 1; user <= 100; user++) {
                if (freq[user] >= k) {
                    countUsers++;
                }
            }

            System.out.println(countUsers);
        }

        sc.close();
    }
}
````