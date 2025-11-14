```java
 import java.util.*;
class Main {
    // Backtracking function to collect all combinations
    static void solve(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds)); // store current combination
            return;
        }

        if (ind == nums.length || target < 0) return;
        // Include current element
        ds.add(nums[ind]);
        solve(ind + 1, nums, target - nums[ind], ds, ans);
        ds.remove(ds.size() - 1); // backtrack

        // Exclude current element
        solve(ind + 1, nums, target, ds, ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Number of items
        int n = scanner.nextInt();
        // Item prices
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // Gift card balance
        int target = scanner.nextInt();
        // Print first line: target * 2 - 1
        System.out.println(target * 2 - 1);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, target, new ArrayList<>(), ans);

        // Print first valid combination if exists
        if (ans.isEmpty()) {
            System.out.println("No combination of items");
        } else {
            List<Integer> first = ans.get(0);
            for (int i = 0; i < first.size(); i++) {
                System.out.print(first.get(i));
                if (i < first.size() - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
````