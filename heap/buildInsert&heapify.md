```java
 import java.util.Scanner;

public class Main {

    // Swap function
    public static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Min-heapify function
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

    // Insert element into the heap
    public static int insertElement(int[] heap, int size, int value) {
        heap[size] = value;
        int i = size;
        size++;

        // Fix the heap property (heapify up)
        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

        return size;
    }

    // Build Min Heap from array
    public static void buildMinHeap(int[] heap, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(heap, size, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] heap = new int[10];  // max size from constraint
        int size = 0;
        double total = 0;

        // Process each input weight
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            if (value > 0) {
                size = insertElement(heap, size, value);
                total += value;
            }
        }

        // Build heap (to ensure correct order)
        buildMinHeap(heap, size);

        if (size == 0) {
            System.out.println("No valid weight");
        } else {
            // Display heap contents
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();

            // Calculate and print average
            double average = total / size;
            System.out.printf("%.2f", average);
        }
    }
}
````