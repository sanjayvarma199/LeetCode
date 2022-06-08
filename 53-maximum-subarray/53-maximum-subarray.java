class Solution {
    //Time O(N)
    //Space O(1)
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int ans = nums[0] , max = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] + ans > nums[i])
            {
                ans += nums[i];
            }
            else
            {
                ans = nums[i];
            }
            max = Math.max(max ,ans);
        }
        return max;
    }
}