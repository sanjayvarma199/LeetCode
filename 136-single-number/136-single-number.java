class Solution {
    //Time O(N)
    //Space O(1)
    public int singleNumber(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int res = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
        {
            //Bit Manupulation
            res ^= nums[i];
        }
        return res;
    }
}