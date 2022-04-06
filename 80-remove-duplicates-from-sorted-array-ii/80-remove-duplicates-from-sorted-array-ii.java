class Solution {
    //Time O(N)
    //Space O(1)
    public int removeDuplicates(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        int slow = 1 , fast = 1, n = nums.length , count = 1;
        while(fast < n)
        {
            if(nums[fast] == nums[fast-1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if(count <= 2)
            {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}