class Solution {
    //Time O(N)
    //Space O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        return AtMost(nums , goal) - AtMost(nums , goal-1);
    }
    
    private int AtMost(int[] nums , int target)
    {
        if(target < 0) return 0;
        int left = 0 , result = 0;
        for(int right = 0 ; right < nums.length ; right++)
        {
            target -= nums[right];
            while(left < nums.length && target < 0)
            {
                target += nums[left];
                left++;
            }
            result += right-left+1;
        }
        return result;
    }
}