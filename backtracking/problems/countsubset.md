```java
 import java.util.*;

class Solution {
    // Recursive function to find subsets whose sum = target
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // add valid subset
            }
            return;
        }

        // Include current element if possible
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1); // backtrack
        }

        // Exclude current element
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> subsetSumCombinations(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        Solution sol = new Solution();
        List<List<Integer>> subsets = sol.subsetSumCombinations(arr, target);

        int count = subsets.size();

        // Print required results
        System.out.println(count);
        if (count % 2 == 0)
            System.out.println(count * 3);
        else
            System.out.println(count + 7);

        sc.close();
    }
}
````