# problem Statement 
  Given a string s, return the longest palindromic substring in s.


# Example 1
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

# Example 2
    Input: s = "cbbd"
    Output: "bb"    

``` java 
 class Solution {
    public static int expand (String s , int left , int right , int n ) {
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right-left-1; 
    }
    public String longestPalindrome(String s) {
        int start = 0 , end = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int odd = expand(s , i , i , n);
            int even = expand(s, i , i+1 , n);

            int len = Math.max(odd,even);
            if (len > end - start) {
                start = i - (len-1)/2; // give the starting index of the palindrome 
                end = i + (len/2);  // give the ending index of the palindrome
            }

        }   
        return s.substring(start,end+1);
    }
}

```
# example for why right-left-1;
    Example: "aba"
    Take center at index 1 (the "b").
    Start: left=1, right=1 → match (b == b). Expand → left=0, right=2.
    Next: s[0] == s[2] → match (a == a). Expand → left=-1, right=3.
    Loop ends (because left < 0).
    At this point:
    The last valid palindrome was from left=0 to right=2.
    But your variables are now at left=-1 and right=3.
    So, the correct length is:

    right - left - 1
    = 3 - (-1) - 1
    = 3

# example for odd and even expand function    
  ![Screenshot](./images/longestPalindrome.png)


# Tc -> O(n2) for loop and O(n) for expand function so overall O(n2)
# Sc -> O(1)


