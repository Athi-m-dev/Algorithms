Sample test cases :
  - Input 1 :
    5
    2 4 6 10 3
    13
    Output 1 :
    69


```java    
import java.util.*;
class Solution {
    // Recursive function to find all subsets whose sum = target
    private void findCombinations(int ind, int[] arr, int target,
                                  List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind + 1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }

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
        List<List<Integer>> ls = sol.subsetSumCombinations(arr, target);

        System.out.println("Subsets with sum " + target + ":");
        for (List<Integer> subset : ls) {
            System.out.println(subset);
        }

        System.out.println("Total subsets found: " + ls.size());

        sc.close();
    }
}
```java

