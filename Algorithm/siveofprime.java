package Algorithm;
import java.util.*;
public class siveofprime {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int mid = (n - 1) / 2;
        boolean[] mark = new boolean[mid + 1];

        for (int i = 1; i <= mid; i++) {
            for (int j = i; (i + j + 2 * i * j) <= mid; j++) {
                mark[i + j + 2 * i * j] = true;
            }
        }
        
        System.out.println("The prime Number up to n is");
        if (n > 2) {
            System.out.print("2" + " ");
        }

        for (int k = 1; k <= mid; k++) {
            if (mark[k] == false) {
                System.out.print((2 * k + 1) + " ");
            }
        }
    }
}

// Time Complecity - O(mid2) + O(mid) if n  = 20 where mid = (n-1)/2 = 9 then time complecity is O(81) + O(9) = O(90)
// space Complecity - O(mark)  