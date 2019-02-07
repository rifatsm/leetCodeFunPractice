33. Search in Rotated Sorted Array.java

// Solution 2: Binary Search, Two pointers 
// Runtime: 7 ms
// TC: O(logn)
// SC: O(1)
/* Approach: Binary Search
*   1. Binary Search with additional conditional check to find in which range the "target" can be.
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null)
            return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        
        // Binary Search
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        
        
        return -1;
    }
}


// Solution 1: Binary Search, Two pointers 
// Runtime: 6 ms 
// TC: O(logn)
// SC: O(1)
/* Approach: Binary Search with finding pivot value
*   1. Find the "pivot" value, where the array rotates. Do this using Binary Searching. 
*   2. Use the "pivot" value to search the "target" using Binary Search. Moding by "pivot" value makes the array appear "sorted"
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            // System.out.println("left: "+left+" right: "+right+" mid: "+mid); // code flow
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        // System.out.println("mid: "+ mid+" value: "+nums[mid]); // code flow
        int pivot = left; 
        int realMid = 0;
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            mid = left + (right - left)/2;
            realMid = (mid + pivot) % (nums.length);
            // System.out.println("left: "+left+" right: "+right+" mid: "+mid+" realMid: "+realMid);    // code flow
            if(nums[realMid] == target)
                return realMid;
            if(nums[realMid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
                
        }
        
        return -1;
    }
}