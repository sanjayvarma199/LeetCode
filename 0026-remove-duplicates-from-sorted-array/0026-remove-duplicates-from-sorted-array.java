class Solution {
    //TC O(N)
    //SC O(1)
    public int removeDuplicates(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int i = 0 , j = 0 , n = nums.length;
        while(i < n && j < n)
        {
            while(j < n && nums[i] == nums[j])
            {
                j++;
            }
            i++;
            if(j < n) nums[i] = nums[j];
        }
        return i;
    }
}