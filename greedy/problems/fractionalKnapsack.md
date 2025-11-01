# problem to practice
 https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1


# Explanation
    The fractional knapsack problem is a classic optimization problem that can be solved using a greedy algorithm. The goal is to maximize the total value of items placed in a knapsack with a fixed capacity, allowing for the inclusion of fractional parts of items.
    Each item has a specific weight and value, and the value-to-weight ratio is used to determine the order in which items are added to the knapsack.

# Example 1:
    Input:
    N = 3, W = 50
    values[] = {60,100,120}
    weight[] = {10,20,30}
    Output: 240.00
    Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
    to get the fractional of the item we do (value/weight)*remaining capacity for ex -> (120/30)*(20(weight we needed)) = 80
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
