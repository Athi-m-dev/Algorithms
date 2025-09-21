# Problem Statement:
    Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

# Example 1:
    Input: N=6, 
    arr[] = {9:00, 9:45, 9:55, 11:00, 15:00, 18:00} 
    dep[] = {9:20, 12:00, 11:30, 11:50, 19:00, 20:00}
    Output:3

 [!Screenshot](../images/unnamed.png)
 # Intersection point
 [!Screenshot](../images/platforms.png)


# Explanation 
   There are at-most three trains at a time. The train at 11:00 arrived but the trains which had arrived at 9:45 and 9:55 have still not departed. So, we need at least three platforms here.  


```java
import java.util.*;
class main {
static int countPlatforms(int n,int arr[],int dep[])
 {
    int ans=1; //final value
    for(int i=0;i<=n-1;i++)
    {
        int count=1; // count of overlapping interval of only this   iteration
        for(int j=i+1;j<=n-1;j++)
        {
            if((arr[i]>=arr[j] && arr[i]<=dep[j]) ||
           (arr[j]>=arr[i] && arr[j]<=dep[i]))
           {
               count++;
           }
        }
        ans=Math.max(ans,count); //updating the value
    }
    return ans;
 }

public static void main (String[] args) {
		
		int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		int totalCount=countPlatforms(n,arr,dep);
		System.out.println("Minimum number of Platforms required "+totalCount);
	}
}

```
# Time complexity: O(n^2)
# Space complexity: O(1)

# optimal 
``` java
import java.util.*;
class Main{
static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
    }
 public static void main (String[] args) {
		
		int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		int totalCount=findPlatform(arr,dep,n);
		System.out.println("Minimum number of Platforms required "+totalCount);
	}
}

```
# Time complexity: O(n log n) due to sorting for both arrival and departure arrays traversal of arrays takes O(n) so overall time complexity is O(nlogn).
# Space complexity: O(1) as we are using a constant amount of extra space.

# Why this greedy approach works:
The greedy approach works here because at any given time, we want to ensure that we have the minimum number of platforms occupied. By sorting the arrival and departure times, we can efficiently determine when a new train arrives and when the earliest departing train leaves. This allows us to keep track of the number of platforms needed without having to check every possible combination of trains, leading to a more optimal solution.

  
  