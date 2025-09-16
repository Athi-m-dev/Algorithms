# Problem Statement: 
  There is one meeting room in a firm. You are given two arrays, start and end each of size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.

# Example 1:
    Input: N = 6, start[] = {1,3,0,5,8,5}, end[] = {2,4,6,7,9,9}
    Output: 4
    Explanation: The maximum number of meetings that can be held is 4. The meetings will be done in the order (1, 2), (3, 4), (5, 7), (8, 9)

# Example 2:
    Input: N = 3, start[] = {10, 12, 20}, end[] = {20, 25, 30}
    Output: 1    
    Explanation: The maximum number of meetings that can be held is 1. The meeting will be done in the order (10, 20)

```java
import java.util.*;
class meeting {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<meeting> {
    public int compare(meeting m1 , meeting m2) {
        if (m1.end < m2.end) {
            return -1;
        }
        else if (m1.end > m2.end) {
            return 1;
        }
        else if (m1.pos < m2.pos) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

public class Main {
    static void maxMeeting (int[] start , int[] end , int n) {
        ArrayList <meeting> meet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meet.add(new meeting(start[i] , end[i] , i+1));
        }
        
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet,mc);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int endlimit = meet.get(0).end;
        ans.add(meet.get(0).pos);
        
        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > endlimit) {
                endlimit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }    
        }
        System.out.println("the order the meeting should be performed");
        
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
 }
    
    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeeting(start,end,n);
    }
}
```

# Why this is a Greedy Approach?
  - We sort the meetings based on their ending times. This allows us to always consider the meeting that finishes the earliest, leaving more room for subsequent meetings.
  - By selecting the meeting that ends the earliest and is compatible with previously selected meetings, we ensure that we are making a choice that maximizes the number of meetings that can be accommodated.
  - This greedy choice is optimal because if we were to select a meeting that ends later, it could potentially block out more meetings that could have been scheduled afterward.
