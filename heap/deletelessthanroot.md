```java
 import java.util.*;

public class Main {

    // Swap two elements in an array
    public static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heapify a subtree rooted with index i
    public static void minHeapify(int[] heap, int size, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(heap, i, smallest);
            minHeapify(heap, size, smallest);
        }
    }

    // Build min heap
    public static void buildMinHeap(int[] heap, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(heap, size, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heap = new int[n];
        for (int i = 0; i < n; i++) {
            heap[i] = sc.nextInt();
        }

        // Step 1: Build initial Min Heap
        buildMinHeap(heap, n);

        // Step 2: Find twice of root's priority
        int twiceRoot = 2 * heap[0];

        // Step 3: Keep only elements >= twiceRoot
        int[] filtered = new int[n];
        int newSize = 0;
        for (int i = 0; i < n; i++) {
            if (heap[i] >= twiceRoot) {
                filtered[newSize++] = heap[i];
            }
        }

        // Step 4: Rebuild heap with remaining elements
        if (newSize == 0) {
            // If no elements remain, print nothing
            return;
        }

        buildMinHeap(filtered, newSize);

        // Step 5: Print the remaining heap elements
        for (int i = 0; i < newSize; i++) {
            System.out.print(filtered[i] + " ");
        }
    }
}
````