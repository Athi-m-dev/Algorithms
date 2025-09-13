# problem to practice
https://leetcode.com/problems/assign-cookies/description/

# Example 1:
            Input: g = [1,2,3], s = [1,1]
            Output: 1
            Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
            And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
            You need to output 1.
            Example 2:
# Example 2:
            Input: g = [1,2], s = [1,2,3]
            Output: 2
            Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
            You have 3 cookies and their sizes are big enough to gratify all of the children, 
            You need to output 2.

```java 
  class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        int l = 0 , r = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (r < m && l < n) {
            if (s[l] >= g[r]) {
                r++;
            }
            l++;
        }
        return r;
    }
}
```

# why this is the greedy approach?
-- We sort both the greed factors and the cookie sizes.
-- so we can try to satisfy the least greedy child first with the smallest available cookie.
-- if we assign the largest cookie to the least greedy child, we might waste a larger cookie that could have satisfied a more greedy child.
-- By sorting both arrays, we ensure that we are always trying to satisfy the least greedy child with the smallest available cookie, which is a greedy choice that leads to an optimal solution.

# Time Complexity: O(n log n + m log m)
-- Sorting both arrays takes O(n log n) and O(m log m) time respectively.
-- The while loop runs in O(n + m) time, where n is the length of the greed factors array and m is the length of the cookie sizes array.