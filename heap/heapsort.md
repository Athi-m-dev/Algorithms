```java
 import java.util.*;

public class Main {

    // 🔁 Separate swap function
    static void swap(String[] heap, int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Heapify function for Max Heap (lexicographic order)
    static void heapify(String[] heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[largest].compareTo(heap[left]) < 0)
            largest = left;

        if (right < n && heap[largest].compareTo(heap[right]) < 0)
            largest = right;

        if (largest != i) {
            swap(heap, i, largest); // 🔁 use swap function
            heapify(heap, n, largest);
        }
    }

    // Heap Sort function
    static void heapSort(String[] heap, int n) {
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(heap, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            swap(heap, 0, i); // 🔁 use swap here too
            heapify(heap, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        heapSort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
````