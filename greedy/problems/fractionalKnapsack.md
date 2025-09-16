# problem to practice
 https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

# Example 1:
    Input:
    N = 3, W = 50
    values[] = {60,100,120}
    weight[] = {10,20,30}
    Output: 240.00
    Explanation: Total maximum value of item
    we can have is 240.00 from the given
    capacity of sack.


# Example 2:
    Input:
    N = 3, W = 50
    values[] = {60,100,120}
    weight[] = {10,20,30}
    Output: 240.00
    Explanation: Total maximum value of item
    we can have is 240.00 from the given
    capacity of sack.


```java  
    import java.util.*;
    class Item {
        int value, weight;
        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public class Solve {
        static double fractionalKnapsack(int W, Item[] items, int n) {
            Arrays.sort(items, (a, b) -> {
                double r1 = (double)a.value / a.weight;
                double r2 = (double)b.value / b.weight;
                return Double.compare(r2, r1);
            });

            double maxValue = 0.0;
            int curWeight = 0;

            for (Item item : items) {
                if (curWeight + item.weight <= W) {
                    // Take the whole item
                    curWeight += item.weight;
                    maxValue += item.value;
                } else {
                    // Take only the fraction that fits
                    int remain = W - curWeight;
                    maxValue += ((double)item.value / item.weight) * remain;
                    break;
                }
            }
            return maxValue;
        }

        public static void main(String[] args) {
            int n = 3, W = 50;
            Item[] items = {
                new Item(100, 20),
                new Item(60, 10),
                new Item(120, 30)
            };
            double ans = fractionalKnapsack(W, items, n);
            System.out.println("The maximum value is " + ans);
        }
    }

# why this is the greedy approach?
    - We always pick the item with the highest value-to-weight ratio.
    - This ensures that we are maximizing the value we get for each unit of weight.
    - By sorting the items and taking the best available option at each step, we are making a series of locally optimal choices.
    - These local choices lead to a globally optimal solution for the fractional knapsack problem.

# Time & Space Complexity: O(n log n)
    - Sorting the items based on their value-to-weight ratio takes O(n log n) time.
    - The subsequent iteration through the items takes O(n) time.
    - Therefore, the overall time complexity is dominated by the sorting step, resulting in O(n log n).
    - The space complexity is O(1) if we ignore the input storage, as we are using a constant amount of extra space.
