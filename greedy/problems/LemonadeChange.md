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
   We prioritize giving change using a $10 bill when available, as it helps preserve $5 bills for future transactions.
   If a $10 bill is not available, we then check if we have at least three $5 bills to make the $15 change.
    suppose u have five = 3 and 10 = 1, now u have bill = 20
    u have 2 possibility:
        either give 3 five or give 1 five and 1 ten
        suppose u give 3 five so now u have 0 five
        now imagine next bill = 10
        for this u need 1 five but u have already exhausted all five so u cant give a change but if u have thought greedily and have given 1 ten and 1 five then u could have given change for bill 10 also
        THEREFORE GREEDY IN THIS PROBLEM IS SAVING AS MANY FIVE AS POSSIBLE SO THAT WE CAN GIVE CHANGE TO MAKE BILLS

# Time Complexity: O(n)
-- The for loop runs in O(n) time, where n is the length of the bills array.