```java
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int Q = sc.nextInt();

        while (Q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Convert to 0-based indexing
            l--;
            r--;

            // Use a HashSet to automatically store unique elements
            Set<Integer> uniqueUsers = new HashSet<>();

            for (int i = l; i <= r; i++) {
                uniqueUsers.add(arr[i]);
            }

            System.out.println(uniqueUsers.size());
        }

        sc.close();
    }
}
````