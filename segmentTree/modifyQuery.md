```java
 // You are using Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        while (Q-- > 0) {
            char op = sc.next().charAt(0);

            if (op == 'M') {
                int L = sc.nextInt();
                int R = sc.nextInt();

                int[] freq = new int[101];

                for (int i = L; i <= R; i++) {
                    freq[arr[i]]++;
                }

                int maxFreq = 0, modeTag = 1;

                for (int tag = 1; tag <= 100; tag++) {
                    if (freq[tag] > maxFreq) {
                        maxFreq = freq[tag];
                        modeTag = tag;
                    }
                }

                System.out.println(modeTag);
            } 
            else if (op == 'U') {
                int i = sc.nextInt();
                //System.out.println(i);
                int val = sc.nextInt();
                arr[i] = val;
                //System.out.println("index: " + i + " "+ arr[i]);
            }
        }

        sc.close();
    }
}
````