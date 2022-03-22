class Solution {
    //Time O(N)
    //Space O(1)
    public int maxSubArray(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        //Logic
        int sum = 0 , result = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum = Math.max(nums[i] , sum + nums[i]);
            result = Math.max(result , sum);
        }
        return result;
    }
}