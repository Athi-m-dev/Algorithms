# problem to practice
https://leetcode.com/problems/lemonade-change/submissions/1769325009/

# Example 1:
    Input: bills = [5,5,5,10,20]
    Output: true
    Explanation: 
    From the first 3 customers, we collect three $5 bills in order.
    From the fourth customer, we collect a $10 bill and give back a $5.
    From the fifth customer, we give a $10 bill and a $5 bill.
    Since all customers got correct change, we output true.

# Example 2:
    Input: bills = [5,5,10,10,20]
    Output: false
    Explanation: 
    From the first two customers in order, we collect two $5 bills.
    For the next two customers in order, we collect a $10 bill and give back a $5 bill.
    For the last customer, we can not give the change of $15 back because we only have two $10 bills.
    Since not every customer received the correct change, the answer is false.

```java 
  class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0 , ten = 0 , n = bills.length;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                if (five > 0) {
                    ten++;
                    five--;
                }
                else {
                    return false;
                }
            }
            else {
                if (ten >0 && five > 0) {
                   ten--;
                   five--;
                }
                else if (five >=3) {
                    five -=3;
                }
                else {
                    return false;
                }
             }
        }
        return true;
    }
}
```

# why this is the greedy approach?
  - Suppose:  
  - You have `five = 3` and `ten = 1`.  
  - Next customer pays with **$20**.  

- Two options to give $15 change:  
  1. **Give three $5 bills** → now you have `five = 0, ten = 1`.  
     - If the next bill is $10, you **cannot** give change.  

  2. **Give one $10 + one $5** → now you have `five = 2, ten = 0`.  
     - If the next bill is $10, you **can** still give change.  

✅ Therefore, the greedy choice (use $10 + $5 first) ensures we don’t get stuck later.  


# Time Complexity: O(n)
 - The for loop runs in O(n) time, where n is the length of the bills array.