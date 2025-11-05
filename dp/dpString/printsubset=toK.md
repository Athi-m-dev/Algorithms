```java
import java.util.*;
public class Main {

    // Recursive function to find all subsets whose sum = target
    private static void findCombinations(int ind, int[] arr, int target,
                                         List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Include current element if it does not exceed target
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1); // backtrack
        }

        // Exclude current element
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    // Function to return all subsets whose sum = target
    private static List<List<Integer>> subsetSumCombinations(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        List<List<Integer>> subsets = subsetSumCombinations(arr, target);

        System.out.println("Subsets with sum " + target + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

        System.out.println("Total subsets found: " + subsets.size());

        sc.close();
    }
}
````