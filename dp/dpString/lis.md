``` java
import java.util.*;
class Main {
    static void getLis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] ss = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(ss, -1);

        int lss = 1;
        int index = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1; // length of the sequence 
                    ss[i] = j; // maintain all the index of the subsequence
                }
            }
            
            if (dp[i] > lss) {
                lss = dp[i];
                index = i;
            }
        }
        
        System.out.println("Length of LIS: " + lss);

        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(arr[index]);
            index = ss[index];
        }

        Collections.reverse(res);

        System.out.print("LIS sequence: ");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        getLis(arr);
        sc.close();
    }
}
```