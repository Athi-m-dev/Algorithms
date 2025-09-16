# Problem Statement:
 - You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 - Return true if you can reach the last index, or false otherwise.


# Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

![Screenshot](images/jumpgame.png)
 
# Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

```java
  class Main {

    static boolean canJump(int[] nums) {
        int n = nums.length;

        int maxIndex = 0;

        for (int i = 0; i < n; ++i) {
            if (i > MaxIndex) return false;

            MaxIndex = Math.max(MaxIndex, i+nums[i]);

            if (maxIndex >= n-1) return true;
        }

        return true;
    }
    public static void main (String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
  }

```

# Why this is a Greedy Approach?
 - The algorithm iteratively updates the farthest index that can be reached at each step. If at any point the current index exceeds the farthest reachable index, it concludes that reaching the last index is impossible.
 - This approach is greedy because it always tries to extend the reachable range as far as possible at each step, ensuring that if there is a way to reach the end, it will find it.


# Problem to Practice 
https://leetcode.com/problems/jump-game/description/