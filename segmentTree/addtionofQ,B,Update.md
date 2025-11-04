```java
// You are using Java
import java.util.*;
class Main {
    static int[] seg;

    // Build Segment Tree
    static void build(int ind, int low, int high, int[] arr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    // Query sum in range [l, r]
    static int query(int ind, int low, int high, int l, int r) {
        // completely inside range
        if (l <= low && high <= r) return seg[ind];

        // completely outside range
        if (high < l || low > r) return 0;

        int mid = (low + high) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return left + right;
    }

    // Update value at index i
    static void update(int ind, int low, int high, int i, int val) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) / 2;
        if (i <= mid)
            update(2 * ind + 1, low, mid, i, val);
        else
            update(2 * ind + 2, mid + 1, high, i, val);

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        seg = new int[4 * N];
        build(0, 0, N - 1, arr);

        while (Q-- > 0) {
            char type = sc.next().charAt(0);

            if (type == 'S') {
                int L = sc.nextInt();
                int R = sc.nextInt();
                System.out.println(query(0, 0, N - 1, L, R));
            } else if (type == 'U') {
                int i = sc.nextInt();
                int val = sc.nextInt();
                update(0, 0, N - 1, i, val);
            }
        }

        sc.close();
    }
}
````