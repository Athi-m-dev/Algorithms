# Problem Statement
 - Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10 } and a target value n. Find the minimum number of coins and/or notes needed to make the change for Rs n. 

    - Note: You can use any denomination any number of times.
# Example 1:
    Input: n = 7
    Output: 2 (We can use one 5-rupee note and one 2-rupee coin)

# Example 2:
    Input: n = 15
    Output: 2 (We can use one 10-rupee note and one 5-rupee note)   


````java
import java.util.*;
class Solve {
    static int mincoins (int n) {
        int[] denominations = {10, 5, 2, 1};
        int count = 0;
        for (int coin : denominations) { // the outer one no consider as the time complexity because In Big-O notation, constants are ignored, so we write O(1). suppose we have 100 denominations then it will be O(100) which is O(1) id O(n) means n is the input size from the user we dont know how many denominations we have
            while (n >= coin) {
                n -= coin;
                count++;
            }
        }
        return count;
    }   

    public static void main(String[] args) {
        int n = 28; // Example input
        System.out.println("Minimum coins/notes needed: " + mincoins(n));
    }
}
````    


# Why this is a Greedy Approach?
 - At each step, we choose the largest denomination that does not exceed the remaining amount. This choice is optimal because it reduces the remaining amount as quickly as possible, minimizing the total number of coins/notes used.
 - For example, if we need to make change for Rs 28:
   - Start with Rs 28, use one 10-rupee note (remaining Rs 18)
   - Use another 10-rupee note (remaining Rs 8)
   - Use one 5-rupee note (remaining Rs 3)
   - Use one 2-rupee coin (remaining Rs 1)
   - Finally, use one 1-rupee coin (remaining Rs 0)
 - Total coins/notes used = 5 (two 10s, one 5, one 2, one 1), which is the minimum possible.


# Time Complexity: O(n) where n is the amount for which we need to make change. In the worst case, we may need to use all denominations multiple times.
# Space Complexity: O(1) as we are using a constant amount of extra space.