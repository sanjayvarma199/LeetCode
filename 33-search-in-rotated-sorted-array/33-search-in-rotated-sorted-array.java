class Solution {
    public int search(int[] nums, int target) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        
        int low = 0 , high = nums.length-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            //If target is found return
            if(nums[mid] == target)
            {
                return mid;
            }
            //Left Half is sorted
            if(nums[low] <= nums[mid])
            {
                // Target is range is in Left half
                if(nums[low] <= target && target < nums[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                // Target is range is in right half
                if(nums[mid] < target && target <= nums[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}