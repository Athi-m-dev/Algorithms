```java
 Check GCD in Range Query:

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++) cin >> arr[i];

    int Q;
    cin >> Q;
    while (Q--) {
        int L, R, K;
        cin >> L >> R >> K;

        int gcd_val = 0;
        bool found = false;

        for (int i = L; i <= R; i++) 
        {
            if (arr[i] % K == 0) 
            {
                if (!found) 
                {
                    gcd_val = arr[i];
                    found = true;
                } 
                else 
                {
                    gcd_val = gcd(gcd_val, arr[i]);
                }
            }
        }

        cout << (found ? gcd_val : 0) << endl;
    }

    return 0;
}
````