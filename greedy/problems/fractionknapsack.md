```java
 // You are using Java
import java.util.*;
class Item {
    int index;
    int weight;
    int value;
    double ratio;

    Item(int index, int weight, int value) {
        this.index = index;
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = obj.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = obj.nextInt();
        }
        int W = obj.nextInt();

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(i + 1, weight[i], value[i]));
        }

        // Sort by value/weight ratio in descending order using lambda
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        double totalValue = 0.0;
        int remainingCapacity = W;

        for (Item it : items) {
            if (remainingCapacity == 0) break;
            if (it.weight <= remainingCapacity) {
                // Take whole item
                remainingCapacity -= it.weight;
                totalValue += it.value;
                System.out.println(
                    "Added object " + it.index +
                    " (Rs. " + it.value + ", " + it.weight + "Kg) completely in the bag. Space left: " +
                    remainingCapacity + "."
                );
            } else {
                // Take fraction of item 
                double fraction = (double) remainingCapacity / it.weight;
                double valAdded = it.value * fraction;
                int percent = (int) (fraction * 100);
                totalValue += valAdded;
                System.out.println(
                    "Added " + percent + "% (Rs." + it.value + ", " + it.weight +
                    "Kg) of object " + it.index + " in the bag."
                );
                remainingCapacity = 0;
            }
        }

          System.out.printf("Filled the bag with objects worth Rs. %.2f.%n", totalValue);
    }
}
````