```java
import java.util.*;
class Main {
    static int[] seg; // global segment tree array

    // Build the segment tree
    static void buildTree(int[] arr, int low, int high, int ind) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        buildTree(arr, low, mid, 2 * ind + 1);
        buildTree(arr, mid + 1, high, 2 * ind + 2);

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    // Query for minimum in range [l, r]
    static int query(int ind, int low, int high, int l, int r) {
        // no overlap
        if (r < low || l > high)
            return Integer.MAX_VALUE;

        // complete overlap
        if (low >= l && high <= r)
            return seg[ind];

        // partial overlap
        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    // Update a single index to a new value
    static void update(int ind, int low, int high, int idx, int val) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) / 2;
        if (idx <= mid)
            update(2 * ind + 1, low, mid, idx, val);
        else
            update(2 * ind + 2, mid + 1, high, idx, val);

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of sensors
        int Q = sc.nextInt(); // number of operations
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        seg = new int[4 * N]; // allocate enough space for tree
        buildTree(arr, 0, N - 1, 0);

        while (Q-- > 0) {
            char type = sc.next().charAt(0);

            if (type == 'Q') { // Query
                int L = sc.nextInt();
                int R = sc.nextInt();
                System.out.println(query(0, 0, N - 1, L, R));
            } else if (type == 'U') { // Update
                int idx = sc.nextInt();
                int val = sc.nextInt();
                update(0, 0, N - 1, idx, val);
            }
        }

        sc.close();
    }
}
````