class Solution {
    //Time O(N)
    //Space O(1)
    public int maxArea(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        //Maintain two pointers
        int low = 0 , high = nums.length-1;
        int result = 0;
        while(low < high)
        {
            result = Math.max(result , Math.min(nums[low] , nums[high]) * (high-low));
            if(nums[low] < nums[high])
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        return result;
    }
}