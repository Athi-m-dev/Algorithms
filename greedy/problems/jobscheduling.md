# problem Statement
    You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

    - Your task is to find:
      - The maximum number of jobs that can be completed within their deadlines.
      - The total maximum profit earned by completing those jobs.


 # Example 1:
    Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
    Output: [2, 60]
    Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).

# Example 2:
    Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
    Output: [2, 127]
    Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).    

```java
   class Job {
        int profit;
        int deadline;
        
        Job(int profit , int deadline) {
            this.profit = profit;
            this.deadline = deadline;
        }
 }

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
       int n = profit.length;
       
       ArrayList<Integer> ans = new ArrayList<Integer>();
       
       Job[] arr = new Job[n];
       
       for (int i = 0; i < n; i++) {
           arr[i] = new Job(profit[i],deadline[i]);
       }
       
       Arrays.sort(arr , (a,b) -> b.profit - a.profit);
       
       int maxi = 0;
       for (int i = 0; i < n; i++) {
           maxi  = Math.max(maxi,arr[i].deadline);
       }
       
       int slots[] = new int[maxi+1];
       Arrays.fill(slots,-1);
       int jbcnt = 0 , jbprofit = 0;
       
       for (int i = 0; i < n; i++) {
           for (int j = arr[i].deadline; j > 0; j--) {
               if (slots[j] == -1) {
                   slots[j] = arr[i].deadline;
                   jbcnt++;
                   jbprofit+=arr[i].profit;
                   break;
               }
           }
       }
                                                   
       ans.add(jbcnt);
       ans.add(jbprofit);
       return ans;
        
    }
}
````



# Why this is greedy
    The job scheduling problem can be solved using a greedy approach because it involves making a series of choices that lead to an optimal solution. The greedy strategy focuses on selecting the most profitable jobs first, while ensuring that each job is completed within its deadline. By sorting the jobs based on profit and then iteratively scheduling them in the latest available time slots, we can maximize the total profit while adhering to the constraints of deadlines. This approach works effectively because it prioritizes immediate gains (high-profit jobs) and efficiently utilizes available time slots, leading to an overall optimal solution.
# Time Complexity: O(n log n) due to sorting the jobs based on profit. and O(n*m) for scheduling jobs, where n is the number of jobs and m is the maximum deadline.
# Space Complexity: O(n) for storing the jobs and the slots array.


# Problem to Practice
 https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1 